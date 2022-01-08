// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target

part of 'news_response.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more informations: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

NewsResponse _$NewsResponseFromJson(Map<String, dynamic> json) {
  return _NewsResponse.fromJson(json);
}

/// @nodoc
class _$NewsResponseTearOff {
  const _$NewsResponseTearOff();

  _NewsResponse call(
      {required String status,
      required int totalResults,
      required List<Articles> articles}) {
    return _NewsResponse(
      status: status,
      totalResults: totalResults,
      articles: articles,
    );
  }

  NewsResponse fromJson(Map<String, Object?> json) {
    return NewsResponse.fromJson(json);
  }
}

/// @nodoc
const $NewsResponse = _$NewsResponseTearOff();

/// @nodoc
mixin _$NewsResponse {
  String get status => throw _privateConstructorUsedError;
  int get totalResults => throw _privateConstructorUsedError;
  List<Articles> get articles => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $NewsResponseCopyWith<NewsResponse> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $NewsResponseCopyWith<$Res> {
  factory $NewsResponseCopyWith(
          NewsResponse value, $Res Function(NewsResponse) then) =
      _$NewsResponseCopyWithImpl<$Res>;
  $Res call({String status, int totalResults, List<Articles> articles});
}

/// @nodoc
class _$NewsResponseCopyWithImpl<$Res> implements $NewsResponseCopyWith<$Res> {
  _$NewsResponseCopyWithImpl(this._value, this._then);

  final NewsResponse _value;
  // ignore: unused_field
  final $Res Function(NewsResponse) _then;

  @override
  $Res call({
    Object? status = freezed,
    Object? totalResults = freezed,
    Object? articles = freezed,
  }) {
    return _then(_value.copyWith(
      status: status == freezed
          ? _value.status
          : status // ignore: cast_nullable_to_non_nullable
              as String,
      totalResults: totalResults == freezed
          ? _value.totalResults
          : totalResults // ignore: cast_nullable_to_non_nullable
              as int,
      articles: articles == freezed
          ? _value.articles
          : articles // ignore: cast_nullable_to_non_nullable
              as List<Articles>,
    ));
  }
}

/// @nodoc
abstract class _$NewsResponseCopyWith<$Res>
    implements $NewsResponseCopyWith<$Res> {
  factory _$NewsResponseCopyWith(
          _NewsResponse value, $Res Function(_NewsResponse) then) =
      __$NewsResponseCopyWithImpl<$Res>;
  @override
  $Res call({String status, int totalResults, List<Articles> articles});
}

/// @nodoc
class __$NewsResponseCopyWithImpl<$Res> extends _$NewsResponseCopyWithImpl<$Res>
    implements _$NewsResponseCopyWith<$Res> {
  __$NewsResponseCopyWithImpl(
      _NewsResponse _value, $Res Function(_NewsResponse) _then)
      : super(_value, (v) => _then(v as _NewsResponse));

  @override
  _NewsResponse get _value => super._value as _NewsResponse;

  @override
  $Res call({
    Object? status = freezed,
    Object? totalResults = freezed,
    Object? articles = freezed,
  }) {
    return _then(_NewsResponse(
      status: status == freezed
          ? _value.status
          : status // ignore: cast_nullable_to_non_nullable
              as String,
      totalResults: totalResults == freezed
          ? _value.totalResults
          : totalResults // ignore: cast_nullable_to_non_nullable
              as int,
      articles: articles == freezed
          ? _value.articles
          : articles // ignore: cast_nullable_to_non_nullable
              as List<Articles>,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_NewsResponse implements _NewsResponse {
  const _$_NewsResponse(
      {required this.status,
      required this.totalResults,
      required this.articles});

  factory _$_NewsResponse.fromJson(Map<String, dynamic> json) =>
      _$$_NewsResponseFromJson(json);

  @override
  final String status;
  @override
  final int totalResults;
  @override
  final List<Articles> articles;

  @override
  String toString() {
    return 'NewsResponse(status: $status, totalResults: $totalResults, articles: $articles)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _NewsResponse &&
            const DeepCollectionEquality().equals(other.status, status) &&
            const DeepCollectionEquality()
                .equals(other.totalResults, totalResults) &&
            const DeepCollectionEquality().equals(other.articles, articles));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(status),
      const DeepCollectionEquality().hash(totalResults),
      const DeepCollectionEquality().hash(articles));

  @JsonKey(ignore: true)
  @override
  _$NewsResponseCopyWith<_NewsResponse> get copyWith =>
      __$NewsResponseCopyWithImpl<_NewsResponse>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_NewsResponseToJson(this);
  }
}

abstract class _NewsResponse implements NewsResponse {
  const factory _NewsResponse(
      {required String status,
      required int totalResults,
      required List<Articles> articles}) = _$_NewsResponse;

  factory _NewsResponse.fromJson(Map<String, dynamic> json) =
      _$_NewsResponse.fromJson;

  @override
  String get status;
  @override
  int get totalResults;
  @override
  List<Articles> get articles;
  @override
  @JsonKey(ignore: true)
  _$NewsResponseCopyWith<_NewsResponse> get copyWith =>
      throw _privateConstructorUsedError;
}

Articles _$ArticlesFromJson(Map<String, dynamic> json) {
  return _Articles.fromJson(json);
}

/// @nodoc
class _$ArticlesTearOff {
  const _$ArticlesTearOff();

  _Articles call(
      {required Source source,
      required dynamic author,
      required String title,
      required dynamic description,
      required String url,
      required dynamic urlToImage,
      required String publishedAt,
      required dynamic content}) {
    return _Articles(
      source: source,
      author: author,
      title: title,
      description: description,
      url: url,
      urlToImage: urlToImage,
      publishedAt: publishedAt,
      content: content,
    );
  }

  Articles fromJson(Map<String, Object?> json) {
    return Articles.fromJson(json);
  }
}

/// @nodoc
const $Articles = _$ArticlesTearOff();

/// @nodoc
mixin _$Articles {
  Source get source => throw _privateConstructorUsedError;
  dynamic get author => throw _privateConstructorUsedError;
  String get title => throw _privateConstructorUsedError;
  dynamic get description => throw _privateConstructorUsedError;
  String get url => throw _privateConstructorUsedError;
  dynamic get urlToImage => throw _privateConstructorUsedError;
  String get publishedAt => throw _privateConstructorUsedError;
  dynamic get content => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $ArticlesCopyWith<Articles> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $ArticlesCopyWith<$Res> {
  factory $ArticlesCopyWith(Articles value, $Res Function(Articles) then) =
      _$ArticlesCopyWithImpl<$Res>;
  $Res call(
      {Source source,
      dynamic author,
      String title,
      dynamic description,
      String url,
      dynamic urlToImage,
      String publishedAt,
      dynamic content});

  $SourceCopyWith<$Res> get source;
}

/// @nodoc
class _$ArticlesCopyWithImpl<$Res> implements $ArticlesCopyWith<$Res> {
  _$ArticlesCopyWithImpl(this._value, this._then);

  final Articles _value;
  // ignore: unused_field
  final $Res Function(Articles) _then;

  @override
  $Res call({
    Object? source = freezed,
    Object? author = freezed,
    Object? title = freezed,
    Object? description = freezed,
    Object? url = freezed,
    Object? urlToImage = freezed,
    Object? publishedAt = freezed,
    Object? content = freezed,
  }) {
    return _then(_value.copyWith(
      source: source == freezed
          ? _value.source
          : source // ignore: cast_nullable_to_non_nullable
              as Source,
      author: author == freezed
          ? _value.author
          : author // ignore: cast_nullable_to_non_nullable
              as dynamic,
      title: title == freezed
          ? _value.title
          : title // ignore: cast_nullable_to_non_nullable
              as String,
      description: description == freezed
          ? _value.description
          : description // ignore: cast_nullable_to_non_nullable
              as dynamic,
      url: url == freezed
          ? _value.url
          : url // ignore: cast_nullable_to_non_nullable
              as String,
      urlToImage: urlToImage == freezed
          ? _value.urlToImage
          : urlToImage // ignore: cast_nullable_to_non_nullable
              as dynamic,
      publishedAt: publishedAt == freezed
          ? _value.publishedAt
          : publishedAt // ignore: cast_nullable_to_non_nullable
              as String,
      content: content == freezed
          ? _value.content
          : content // ignore: cast_nullable_to_non_nullable
              as dynamic,
    ));
  }

  @override
  $SourceCopyWith<$Res> get source {
    return $SourceCopyWith<$Res>(_value.source, (value) {
      return _then(_value.copyWith(source: value));
    });
  }
}

/// @nodoc
abstract class _$ArticlesCopyWith<$Res> implements $ArticlesCopyWith<$Res> {
  factory _$ArticlesCopyWith(_Articles value, $Res Function(_Articles) then) =
      __$ArticlesCopyWithImpl<$Res>;
  @override
  $Res call(
      {Source source,
      dynamic author,
      String title,
      dynamic description,
      String url,
      dynamic urlToImage,
      String publishedAt,
      dynamic content});

  @override
  $SourceCopyWith<$Res> get source;
}

/// @nodoc
class __$ArticlesCopyWithImpl<$Res> extends _$ArticlesCopyWithImpl<$Res>
    implements _$ArticlesCopyWith<$Res> {
  __$ArticlesCopyWithImpl(_Articles _value, $Res Function(_Articles) _then)
      : super(_value, (v) => _then(v as _Articles));

  @override
  _Articles get _value => super._value as _Articles;

  @override
  $Res call({
    Object? source = freezed,
    Object? author = freezed,
    Object? title = freezed,
    Object? description = freezed,
    Object? url = freezed,
    Object? urlToImage = freezed,
    Object? publishedAt = freezed,
    Object? content = freezed,
  }) {
    return _then(_Articles(
      source: source == freezed
          ? _value.source
          : source // ignore: cast_nullable_to_non_nullable
              as Source,
      author: author == freezed
          ? _value.author
          : author // ignore: cast_nullable_to_non_nullable
              as dynamic,
      title: title == freezed
          ? _value.title
          : title // ignore: cast_nullable_to_non_nullable
              as String,
      description: description == freezed
          ? _value.description
          : description // ignore: cast_nullable_to_non_nullable
              as dynamic,
      url: url == freezed
          ? _value.url
          : url // ignore: cast_nullable_to_non_nullable
              as String,
      urlToImage: urlToImage == freezed
          ? _value.urlToImage
          : urlToImage // ignore: cast_nullable_to_non_nullable
              as dynamic,
      publishedAt: publishedAt == freezed
          ? _value.publishedAt
          : publishedAt // ignore: cast_nullable_to_non_nullable
              as String,
      content: content == freezed
          ? _value.content
          : content // ignore: cast_nullable_to_non_nullable
              as dynamic,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_Articles implements _Articles {
  const _$_Articles(
      {required this.source,
      required this.author,
      required this.title,
      required this.description,
      required this.url,
      required this.urlToImage,
      required this.publishedAt,
      required this.content});

  factory _$_Articles.fromJson(Map<String, dynamic> json) =>
      _$$_ArticlesFromJson(json);

  @override
  final Source source;
  @override
  final dynamic author;
  @override
  final String title;
  @override
  final dynamic description;
  @override
  final String url;
  @override
  final dynamic urlToImage;
  @override
  final String publishedAt;
  @override
  final dynamic content;

  @override
  String toString() {
    return 'Articles(source: $source, author: $author, title: $title, description: $description, url: $url, urlToImage: $urlToImage, publishedAt: $publishedAt, content: $content)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Articles &&
            const DeepCollectionEquality().equals(other.source, source) &&
            const DeepCollectionEquality().equals(other.author, author) &&
            const DeepCollectionEquality().equals(other.title, title) &&
            const DeepCollectionEquality()
                .equals(other.description, description) &&
            const DeepCollectionEquality().equals(other.url, url) &&
            const DeepCollectionEquality()
                .equals(other.urlToImage, urlToImage) &&
            const DeepCollectionEquality()
                .equals(other.publishedAt, publishedAt) &&
            const DeepCollectionEquality().equals(other.content, content));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(source),
      const DeepCollectionEquality().hash(author),
      const DeepCollectionEquality().hash(title),
      const DeepCollectionEquality().hash(description),
      const DeepCollectionEquality().hash(url),
      const DeepCollectionEquality().hash(urlToImage),
      const DeepCollectionEquality().hash(publishedAt),
      const DeepCollectionEquality().hash(content));

  @JsonKey(ignore: true)
  @override
  _$ArticlesCopyWith<_Articles> get copyWith =>
      __$ArticlesCopyWithImpl<_Articles>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_ArticlesToJson(this);
  }
}

abstract class _Articles implements Articles {
  const factory _Articles(
      {required Source source,
      required dynamic author,
      required String title,
      required dynamic description,
      required String url,
      required dynamic urlToImage,
      required String publishedAt,
      required dynamic content}) = _$_Articles;

  factory _Articles.fromJson(Map<String, dynamic> json) = _$_Articles.fromJson;

  @override
  Source get source;
  @override
  dynamic get author;
  @override
  String get title;
  @override
  dynamic get description;
  @override
  String get url;
  @override
  dynamic get urlToImage;
  @override
  String get publishedAt;
  @override
  dynamic get content;
  @override
  @JsonKey(ignore: true)
  _$ArticlesCopyWith<_Articles> get copyWith =>
      throw _privateConstructorUsedError;
}

Source _$SourceFromJson(Map<String, dynamic> json) {
  return _Source.fromJson(json);
}

/// @nodoc
class _$SourceTearOff {
  const _$SourceTearOff();

  _Source call({required dynamic id, required String name}) {
    return _Source(
      id: id,
      name: name,
    );
  }

  Source fromJson(Map<String, Object?> json) {
    return Source.fromJson(json);
  }
}

/// @nodoc
const $Source = _$SourceTearOff();

/// @nodoc
mixin _$Source {
  dynamic get id => throw _privateConstructorUsedError;
  String get name => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $SourceCopyWith<Source> get copyWith => throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $SourceCopyWith<$Res> {
  factory $SourceCopyWith(Source value, $Res Function(Source) then) =
      _$SourceCopyWithImpl<$Res>;
  $Res call({dynamic id, String name});
}

/// @nodoc
class _$SourceCopyWithImpl<$Res> implements $SourceCopyWith<$Res> {
  _$SourceCopyWithImpl(this._value, this._then);

  final Source _value;
  // ignore: unused_field
  final $Res Function(Source) _then;

  @override
  $Res call({
    Object? id = freezed,
    Object? name = freezed,
  }) {
    return _then(_value.copyWith(
      id: id == freezed
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as dynamic,
      name: name == freezed
          ? _value.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
abstract class _$SourceCopyWith<$Res> implements $SourceCopyWith<$Res> {
  factory _$SourceCopyWith(_Source value, $Res Function(_Source) then) =
      __$SourceCopyWithImpl<$Res>;
  @override
  $Res call({dynamic id, String name});
}

/// @nodoc
class __$SourceCopyWithImpl<$Res> extends _$SourceCopyWithImpl<$Res>
    implements _$SourceCopyWith<$Res> {
  __$SourceCopyWithImpl(_Source _value, $Res Function(_Source) _then)
      : super(_value, (v) => _then(v as _Source));

  @override
  _Source get _value => super._value as _Source;

  @override
  $Res call({
    Object? id = freezed,
    Object? name = freezed,
  }) {
    return _then(_Source(
      id: id == freezed
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as dynamic,
      name: name == freezed
          ? _value.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$_Source implements _Source {
  const _$_Source({required this.id, required this.name});

  factory _$_Source.fromJson(Map<String, dynamic> json) =>
      _$$_SourceFromJson(json);

  @override
  final dynamic id;
  @override
  final String name;

  @override
  String toString() {
    return 'Source(id: $id, name: $name)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Source &&
            const DeepCollectionEquality().equals(other.id, id) &&
            const DeepCollectionEquality().equals(other.name, name));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(id),
      const DeepCollectionEquality().hash(name));

  @JsonKey(ignore: true)
  @override
  _$SourceCopyWith<_Source> get copyWith =>
      __$SourceCopyWithImpl<_Source>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$_SourceToJson(this);
  }
}

abstract class _Source implements Source {
  const factory _Source({required dynamic id, required String name}) =
      _$_Source;

  factory _Source.fromJson(Map<String, dynamic> json) = _$_Source.fromJson;

  @override
  dynamic get id;
  @override
  String get name;
  @override
  @JsonKey(ignore: true)
  _$SourceCopyWith<_Source> get copyWith => throw _privateConstructorUsedError;
}
