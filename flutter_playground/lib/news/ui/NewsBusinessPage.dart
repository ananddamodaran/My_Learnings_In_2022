import 'package:chopper/chopper.dart';
import 'package:flutter/material.dart';
import 'package:flutter_playground/news/api/service/news_service.dart';
import 'package:flutter_playground/news/data/model/news_response.dart';
import 'package:provider/provider.dart';

import '../../main.dart';

class BusinessNews extends StatelessWidget {
  final String title;
  const BusinessNews({Key? key, required this.title}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(child: _buildBody(context));
  }

  FutureBuilder<Response<NewsResponse>> _buildBody(BuildContext context) {
    return FutureBuilder<Response<NewsResponse>>(
      // 2
      future:
          Provider.of<NewsService>(context).getBusinessNews("in", "business"),
      builder: (context, snapshot) {
        // 3
        if (snapshot.connectionState == ConnectionState.done) {
          // 4
          if (snapshot.hasError) {
            return Center(
              child: Text(
                snapshot.error.toString(),
                textAlign: TextAlign.center,
                textScaleFactor: 1.3,
              ),
            );
          }
          // 5
          final buisnessNews = snapshot.data!.body;
          // 6
          return _buildNewsList(context, buisnessNews!);
        } else {
          // 7
          // Show a loading indicator while waiting for the movies
          return const Center(
            child: CircularProgressIndicator(),
          );
        }
      },
    );
  }

  ListView _buildNewsList(BuildContext context, NewsResponse businessNews) {
    log.info("total : ${businessNews.totalResults}");
    return ListView.builder(
      // 2
      itemCount: businessNews.totalResults,
      padding: const EdgeInsets.all(8),
      itemBuilder: (context, index) {
        // 3
        return Card(
          elevation: 4,
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.start,
              children: <Widget>[
                Expanded(
                  child: Column(
                    children: <Widget>[
                      // 5
                      Text(
                        businessNews.articles[index].title,
                        style: TextStyle(fontSize: 14),
                      ),
                      const SizedBox(
                        height: 8,
                      ),
                    ],
                  ),
                )
              ],
            ),
          ),
        );
      },
    );
  }
}
