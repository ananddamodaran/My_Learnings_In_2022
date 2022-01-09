import 'package:auto_route/auto_route.dart';
import 'package:flutter_playground/news/ui/business/business_page.dart';

import '../detail_page.dart';

export 'app_route.gr.dart';

@AdaptiveAutoRouter(
  replaceInRouteName: 'Page,Route',
  routes: <AutoRoute>[
    AutoRoute(
      path: '/',
      page: BusinessPage,
      initial: true,
    ),
    AutoRoute(
      path: '/detail',
      page: DetailPage,
    ),
  ],
)
class $AppRouter {}
