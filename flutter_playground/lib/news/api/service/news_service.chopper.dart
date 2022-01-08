// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'news_service.dart';

// **************************************************************************
// ChopperGenerator
// **************************************************************************

// ignore_for_file: always_put_control_body_on_new_line, always_specify_types, prefer_const_declarations
class _$NewsService extends NewsService {
  _$NewsService([ChopperClient? client]) {
    if (client == null) return;
    this.client = client;
  }

  @override
  final definitionType = NewsService;

  @override
  Future<Response<NewsResponse>> getBusinessNews(
      String country, String category) {
    final $url = 'top-headlines';
    final $params = <String, dynamic>{'country': country, 'category': category};
    final $request = Request('GET', $url, client.baseUrl, parameters: $params);
    return client.send<NewsResponse, NewsResponse>($request);
  }
}
