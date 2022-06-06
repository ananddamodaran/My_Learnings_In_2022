import 'package:equatable/equatable.dart';

abstract class ThemeEvent extends Equatable {
  @override
  List<Object?> get props => [];
}

class ChangeThemeEvent extends ThemeEvent {
  final int randomInt;

  ChangeThemeEvent({required this.randomInt});
  @override
  String toString() => 'ChangeThemeEvent(randomInt:$randomInt)';
  @override
  List<Object?> get props => [randomInt];
}
