import 'package:flutter_playground/news/data/model/news_response.dart';
import 'package:flutter_playground/news/data/model/result.dart';

abstract class NewsRepository {
  Future<Result<NewsResponse>> getNews();
  Future<Result<NewsResponse>> getBusinessNews();
}
