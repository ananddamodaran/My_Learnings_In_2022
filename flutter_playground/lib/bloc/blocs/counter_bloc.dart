import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_playground/bloc/blocs/counter_event.dart';
import 'package:flutter_playground/bloc/cubits/counter_state.dart';

class CounterBloc extends Bloc<CounterEvent, CounterState> {
  CounterBloc() : super(CounterState.initial()) {
    on<IncrementCounterEvent>(
        (event, emit) => {emit(state.copyWith(counter: state.counter + 1))});

    on<DecrementCounterEvent>(_decrementCounter);
  }
  void _decrementCounter(
      DecrementCounterEvent event, Emitter<CounterState> emit) {
    emit(state.copyWith(counter: state.counter - 1));
  }
}
