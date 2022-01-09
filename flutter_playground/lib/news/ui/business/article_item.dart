import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_playground/news/data/model/news_response.dart';
import 'package:flutter_playground/news/ui/hook/use_router.dart';
import 'package:flutter_playground/news/ui/route/app_route.gr.dart';
import 'package:flutter_playground/news/ui/theme/app_text_theme.dart';
import 'package:flutter_playground/news/ui/theme/app_theme.dart';
import 'package:hooks_riverpod/hooks_riverpod.dart';

class ArticleItem extends HookConsumerWidget {
  const ArticleItem({
    Key? key,
    required this.article,
  }) : super(key: key);

  final Articles article;

  static BorderRadius borderRadiusAll = BorderRadius.circular(8);
  static BorderRadius borderRadiusTop = const BorderRadius.only(
    topRight: Radius.circular(8),
    topLeft: Radius.circular(8),
    bottomLeft: Radius.circular(0),
    bottomRight: Radius.circular(0),
  );

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final theme = ref.watch(appThemeProvider);
    final router = useRouter();
    return Card(
      shape: RoundedRectangleBorder(borderRadius: borderRadiusAll),
      elevation: 4,
      child: InkWell(
        child: Column(
          children: <Widget>[
            Hero(
              tag: article,
              child: SizedBox(
                width: double.infinity,
                height: 200,
                child: ClipRRect(
                    borderRadius: borderRadiusTop,
                    child: Image.network(
                      article.urlToImage,
                      fit: BoxFit.fill,
                      errorBuilder: (context, url, dynamic error) =>
                          const CircularProgressIndicator(),
                    )),
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(8),
              child: Text(
                article.title,
                style: theme.textTheme.h20.dense(),
              ),
            ),
          ],
        ),
        onTap: () => router.push(DetailRoute()),
      ),
    );
  }
}
