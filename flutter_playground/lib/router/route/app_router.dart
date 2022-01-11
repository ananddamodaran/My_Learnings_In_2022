import 'package:auto_route/annotations.dart';
import 'package:auto_route/auto_route.dart';
import 'package:flutter/material.dart';
import 'package:flutter_playground/router/ui/home_page.dart';
import 'package:flutter_playground/router/ui/second_page.dart';

part 'app_router.gr.dart';

@MaterialAutoRouter(
  replaceInRouteName: 'Page,Route',
  routes: <AutoRoute>[
    AutoRoute(page: HomePage, initial: true),
    AutoRoute(page: SecondPage)
  ],
)
// extend the generated private router
class MyAppRouters extends _$MyAppRouters {}
