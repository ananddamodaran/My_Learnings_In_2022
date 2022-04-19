import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_playground/bloc/cubits/counter_state.dart';

class CounterCubit extends Cubit<CounterState> {
  CounterCubit() : super(CounterState.initial());

  void increment() {
    final incValueState = state.copyWith(counter: state.counter + 1);
    print(incValueState);
    emit(incValueState);
  }

  void decrement() {
    final decValueState = state.copyWith(counter: state.counter - 1);
    print(decValueState);
    emit(decValueState);
  }
}
