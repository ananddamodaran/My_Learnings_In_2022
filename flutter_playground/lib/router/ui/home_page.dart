import 'package:auto_route/auto_route.dart';
import 'package:flutter/material.dart';
import 'package:flutter_playground/router/route/app_router.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final router = AutoRouter.of(context);
    return Center(
        child: ElevatedButton(
            onPressed: () {
              router.push(SecondRoute(value: 3));
            },
            child: const Text("Home page")));
  }
}
