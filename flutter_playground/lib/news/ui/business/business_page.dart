import 'package:flutter/material.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_hooks/flutter_hooks.dart';
import 'package:flutter_playground/news/foundation/extension/async_snapshot.dart';
import 'package:flutter_playground/news/ui/component/loading/container_with_loading.dart';
import 'package:hooks_riverpod/hooks_riverpod.dart';

import '../loading_state_view_model.dart';
import 'article_item.dart';
import 'news_view_model.dart';

class BusinessPage extends HookConsumerWidget {
  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final homeViewModel = ref.read(newsViewModelProvider);
    final news = ref.watch(newsViewModelProvider.select((value) => value.news));
    final snapshot = useFuture(
      useMemoized(() {
        return ref
            .read(loadingStateProvider)
            .whileLoading(homeViewModel.fetchNews);
      }, [news?.toString()]),
    );
    return ContainerWithLoading(
      child: snapshot.isWaiting || news == null
          ? const SizedBox()
          : news.when(success: (data) {
              if (data.articles.isEmpty) {
                return const Center(child: Text('No Result'));
              }
              return RefreshIndicator(
                onRefresh: () async => homeViewModel.fetchNews(),
                child: ListView.builder(
                  itemCount: data.articles.length,
                  itemBuilder: (_, index) {
                    return ArticleItem(article: data.articles[index]);
                  },
                ),
              );
            }, failure: (e) {
              return const Center(child: Text('Fetch Failed'));
            }),
    );
  }
}
