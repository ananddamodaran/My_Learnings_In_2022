// **************************************************************************
// AutoRouteGenerator
// **************************************************************************

// GENERATED CODE - DO NOT MODIFY BY HAND

// **************************************************************************
// AutoRouteGenerator
// **************************************************************************
//
// ignore_for_file: type=lint

part of 'app_router.dart';

class _$MyAppRouters extends RootStackRouter {
  _$MyAppRouters([GlobalKey<NavigatorState>? navigatorKey])
      : super(navigatorKey);

  @override
  final Map<String, PageFactory> pagesMap = {
    HomeRoute.name: (routeData) {
      return MaterialPageX<dynamic>(
          routeData: routeData, child: const HomePage());
    },
    SecondRoute.name: (routeData) {
      final args = routeData.argsAs<SecondRouteArgs>();
      return MaterialPageX<dynamic>(
          routeData: routeData,
          child: SecondPage(key: args.key, value: args.value));
    }
  };

  @override
  List<RouteConfig> get routes => [
        RouteConfig(HomeRoute.name, path: '/'),
        RouteConfig(SecondRoute.name, path: '/second-page')
      ];
}

/// generated route for
/// [HomePage]
class HomeRoute extends PageRouteInfo<void> {
  const HomeRoute() : super(HomeRoute.name, path: '/');

  static const String name = 'HomeRoute';
}

/// generated route for
/// [SecondPage]
class SecondRoute extends PageRouteInfo<SecondRouteArgs> {
  SecondRoute({Key? key, required int value})
      : super(SecondRoute.name,
            path: '/second-page',
            args: SecondRouteArgs(key: key, value: value));

  static const String name = 'SecondRoute';
}

class SecondRouteArgs {
  const SecondRouteArgs({this.key, required this.value});

  final Key? key;

  final int value;

  @override
  String toString() {
    return 'SecondRouteArgs{key: $key, value: $value}';
  }
}
