// **************************************************************************
// AutoRouteGenerator
// **************************************************************************

// GENERATED CODE - DO NOT MODIFY BY HAND

// **************************************************************************
// AutoRouteGenerator
// **************************************************************************
//
// ignore_for_file: type=lint

import 'package:auto_route/auto_route.dart' as _i3;
import 'package:flutter/material.dart' as _i4;
import 'package:flutter_playground/news/ui/business/business_page.dart' as _i1;
import 'package:flutter_playground/news/ui/detail_page.dart' as _i2;

class AppRouter extends _i3.RootStackRouter {
  AppRouter([_i4.GlobalKey<_i4.NavigatorState>? navigatorKey])
      : super(navigatorKey);

  @override
  final Map<String, _i3.PageFactory> pagesMap = {
    BusinessRoute.name: (routeData) {
      return _i3.AdaptivePage<dynamic>(
          routeData: routeData, child: _i1.BusinessPage());
    },
    DetailRoute.name: (routeData) {
      return _i3.AdaptivePage<dynamic>(
          routeData: routeData, child: const _i2.DetailPage());
    }
  };

  @override
  List<_i3.RouteConfig> get routes => [
        _i3.RouteConfig(BusinessRoute.name, path: '/'),
        _i3.RouteConfig(DetailRoute.name, path: '/detail')
      ];
}

/// generated route for
/// [_i1.BusinessPage]
class BusinessRoute extends _i3.PageRouteInfo<void> {
  const BusinessRoute() : super(BusinessRoute.name, path: '/');

  static const String name = 'BusinessRoute';
}

/// generated route for
/// [_i2.DetailPage]
class DetailRoute extends _i3.PageRouteInfo<void> {
  const DetailRoute() : super(DetailRoute.name, path: '/detail');

  static const String name = 'DetailRoute';
}
