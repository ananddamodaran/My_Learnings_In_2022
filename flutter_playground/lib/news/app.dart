import 'package:flutter/material.dart';
import 'package:flutter_playground/news/ui/NewsBusinessPage.dart';
import 'package:provider/provider.dart';

import 'api/service/news_service.dart';

class NewsApp extends StatelessWidget {
  const NewsApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Provider(
        create: (_) => NewsService.create(),
        dispose: (_, NewsService service) => service.client.dispose(),
        child: MaterialApp(
          title: 'News Page',
          theme: ThemeData(
            primarySwatch: Colors.blue,
          ),
          home: const BusinessNews(title: 'Business'),
        ));
  }
}
