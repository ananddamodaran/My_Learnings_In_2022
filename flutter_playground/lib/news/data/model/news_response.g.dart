// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'news_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$_NewsResponse _$$_NewsResponseFromJson(Map<String, dynamic> json) =>
    _$_NewsResponse(
      status: json['status'] as String,
      totalResults: json['totalResults'] as int,
      articles: (json['articles'] as List<dynamic>)
          .map((e) => Articles.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$$_NewsResponseToJson(_$_NewsResponse instance) =>
    <String, dynamic>{
      'status': instance.status,
      'totalResults': instance.totalResults,
      'articles': instance.articles,
    };

_$_Articles _$$_ArticlesFromJson(Map<String, dynamic> json) => _$_Articles(
      source: Source.fromJson(json['source'] as Map<String, dynamic>),
      author: json['author'],
      title: json['title'] as String,
      description: json['description'],
      url: json['url'] as String,
      urlToImage: json['urlToImage'],
      publishedAt: json['publishedAt'] as String,
      content: json['content'],
    );

Map<String, dynamic> _$$_ArticlesToJson(_$_Articles instance) =>
    <String, dynamic>{
      'source': instance.source,
      'author': instance.author,
      'title': instance.title,
      'description': instance.description,
      'url': instance.url,
      'urlToImage': instance.urlToImage,
      'publishedAt': instance.publishedAt,
      'content': instance.content,
    };

_$_Source _$$_SourceFromJson(Map<String, dynamic> json) => _$_Source(
      id: json['id'],
      name: json['name'] as String,
    );

Map<String, dynamic> _$$_SourceToJson(_$_Source instance) => <String, dynamic>{
      'id': instance.id,
      'name': instance.name,
    };
