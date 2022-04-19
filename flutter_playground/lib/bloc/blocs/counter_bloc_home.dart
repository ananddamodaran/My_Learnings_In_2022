import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_playground/bloc/blocs/counter_bloc.dart';
import 'package:flutter_playground/bloc/blocs/counter_event.dart';

class CounterBlocHome extends StatelessWidget {
  const CounterBlocHome({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Counter app'),
      ),
      body: Center(
          child: Text(
        '${context.watch<CounterBloc>().state.counter}',
        style: const TextStyle(fontSize: 56.0),
      )),
      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          FloatingActionButton(
              heroTag: 'increment',
              child: const Icon(Icons.add),
              onPressed: () {
                // BlocProvider.of<CounterCubit>(context).increment();
                context.read<CounterBloc>().add(IncrementCounterEvent());
              }),
          const SizedBox(
            width: 10,
          ),
          FloatingActionButton(
              heroTag: 'decrement',
              child: const Icon(Icons.remove),
              onPressed: () {
                //BlocProvider.of<CounterCubit>(context).decrement();
                context.read<CounterBloc>().add(DecrementCounterEvent());
              }),
        ],
      ),
    );
  }
}
