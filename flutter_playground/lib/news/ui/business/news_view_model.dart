import 'package:flutter/foundation.dart';
import 'package:flutter_playground/news/data/model/news_response.dart';
import 'package:flutter_playground/news/data/model/result.dart';
import 'package:flutter_playground/news/data/repository/news_repository.dart';
import 'package:flutter_playground/news/data/repository/news_repository_impl.dart';
import 'package:hooks_riverpod/hooks_riverpod.dart';

final newsViewModelProvider =
    ChangeNotifierProvider((ref) => NewsViewModel(ref.read));

class NewsViewModel extends ChangeNotifier {
  NewsViewModel(this._reader);

  final Reader _reader;

  late final NewsRepository _repository = _reader(newsRepositoryProvider);

  // Result use case No.1
  Result<NewsResponse>? _news;

  Result<NewsResponse>? get news => _news;

  Future<void> fetchNews() {
    return _repository
        .getNews()
        .then((value) => _news = value)
        .whenComplete(notifyListeners);
  }
}
