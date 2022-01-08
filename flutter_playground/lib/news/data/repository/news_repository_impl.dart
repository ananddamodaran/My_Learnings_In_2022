import 'dart:math';

import 'package:flutter_playground/news/data/model/news_response.dart';
import 'package:flutter_playground/news/data/model/result.dart';
import 'package:flutter_playground/news/data/remote/news_data_source.dart';
import 'package:flutter_playground/news/foundation/extension/date_time.dart';
import 'package:hooks_riverpod/hooks_riverpod.dart';

import 'news_repository.dart';

final newsRepositoryProvider = Provider((ref) => NewsRepositoryImpl(ref.read));

class NewsRepositoryImpl implements NewsRepository {
  NewsRepositoryImpl(this._reader);

  final Reader _reader;

  late final NewsDataSource _dataSource = _reader(newsDataSourceProvider);

  @override
  Future<Result<NewsResponse>> getNews() {
    return Result.guardFuture(
      () async => await _dataSource.getNews(
        query: ['anim', 'manga'][Random().nextInt(2)],
        // For checking reload.
        from: DateTime.now()
            .subtract(const Duration(days: 28))
            .toLocal()
            .formatYYYYMMdd(),
        apiKey: '',
      ),
    );
  }

  @override
  Future<Result<NewsResponse>> getBusinessNews() {
    return Result.guardFuture(() async => await _dataSource.getBusinessNews());
  }
}
