import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_playground/bloc/cubits/counter_cubit.dart';
import 'package:flutter_playground/bloc/cubits/counter_state.dart';
import 'package:flutter_playground/bloc/error_page.dart';

void main() {
  runApp(const CounterApp());
}

class CounterApp extends StatelessWidget {
  const CounterApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return BlocProvider<CounterCubit>(
      create: (context) => CounterCubit(),
      child: MaterialApp(
        title: 'Counter App',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(primarySwatch: Colors.blue),
        home: const CounterHome(),
      ),
    );
  }
}

class CounterHome extends StatelessWidget {
  const CounterHome({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Counter app'),
      ),
      body: BlocConsumer<CounterCubit, CounterState>(builder: (context, state) {
        return Center(
            child: Text(
          '${state.counter}',
          style: const TextStyle(fontSize: 56.0),
        ));
      }, listener: (context, state) {
        if (state.counter == 3) {
          showDialog(
              context: context,
              builder: (context) {
                return const AlertDialog(
                  content: Text('hello'),
                );
              });
        } else if (state.counter == -1) {
          Navigator.push(context, MaterialPageRoute(builder: (context) {
            return const ErrorPage();
          }));
        }
      }),
      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          FloatingActionButton(
              heroTag: 'increment',
              child: const Icon(Icons.add),
              onPressed: () {
                // BlocProvider.of<CounterCubit>(context).increment();
                context.read<CounterCubit>().increment();
              }),
          const SizedBox(
            width: 10,
          ),
          FloatingActionButton(
              heroTag: 'decrement',
              child: const Icon(Icons.remove),
              onPressed: () {
                //BlocProvider.of<CounterCubit>(context).decrement();
                context.read<CounterCubit>().decrement();
              }),
        ],
      ),
    );
  }
}
