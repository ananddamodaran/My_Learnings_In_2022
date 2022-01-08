import 'package:chopper/chopper.dart';
import 'package:flutter_playground/news/data/model/news_response.dart';

import 'model_convertor.dart';

part 'news_service.chopper.dart';

@ChopperApi()
abstract class NewsService extends ChopperService {
  @Get(path: 'top-headlines')
  Future<Response<NewsResponse>> getBusinessNews(
    @Query() String country,
    @Query() String category,
  );
  static NewsService create() {
    final client = ChopperClient(
      baseUrl: 'https://newsapi.org/v2',
      interceptors: [
        _addQuery,
        //HeaderInterceptor(),
        HttpLoggingInterceptor()
      ],
      converter: ModelConverter(),
      errorConverter: const JsonConverter(),
      services: [
        _$NewsService(),
      ],
    );
    return _$NewsService(client);
  }

  static Request _addQuery(Request req) {
    final params = Map<String, dynamic>.from(req.parameters);
    params['apiKey'] = '24802f736c1d41889bb99f0e5b9c8ea2';

    return req.copyWith(parameters: params);
  }
}
