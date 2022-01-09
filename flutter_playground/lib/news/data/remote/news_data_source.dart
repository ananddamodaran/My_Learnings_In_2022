import 'package:dio/dio.dart';
import 'package:flutter_playground/news/data/model/news_response.dart';
import 'package:hooks_riverpod/hooks_riverpod.dart';
import 'package:retrofit/retrofit.dart';

import 'app_dio.dart';

part 'news_data_source.g.dart';

final newsDataSourceProvider = Provider((ref) => NewsDataSource(ref.read));

@RestApi()
abstract class NewsDataSource {
  factory NewsDataSource(Reader reader) => _NewsDataSource(reader(dioProvider));

  @GET('/v2/everything')
  Future<NewsResponse> getNews({
    @Query("q") required String query,
    @Query("from") required String from,
    @Query("sortBy") String? sortBy = 'publishedAt',
    @Query("language") String? language = 'en',
    @Query("apiKey") required String apiKey,
  });

  @GET('/top-headlines')
  Future<NewsResponse> getBusinessNews({
    @Query("country") String country = "in",
    @Query("category") String category = "business",
    @Query("apiKey") String apiKey = "24802f736c1d41889bb99f0e5b9c8ea2",
  });
}
