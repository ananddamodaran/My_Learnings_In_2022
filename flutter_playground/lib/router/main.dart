import 'package:flutter/material.dart';
import 'package:flutter_playground/router/route/app_router.dart';

void main() {
  runApp(MyAppRouter());
}

class MyAppRouter extends StatelessWidget {
  final appRouter = MyAppRouters();

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      routerDelegate: appRouter.delegate(),
      routeInformationParser: appRouter.defaultRouteParser(),
    );
  }
}
