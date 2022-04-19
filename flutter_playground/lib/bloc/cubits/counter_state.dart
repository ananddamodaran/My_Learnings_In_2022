import 'package:equatable/equatable.dart';

class CounterState extends Equatable {
  final int counter;

  CounterState({required this.counter});

  factory CounterState.initial() {
    return CounterState(counter: 0);
  }
  @override
  String toString() => 'CounterState(counter: $counter)';
  @override
  List<Object?> get props => [counter];

  CounterState copyWith({int? counter}) {
    return CounterState(counter: counter ?? this.counter);
  }
}
