import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_playground/bloc/cubit2cubit/color_cubit/color_cubit.dart';
import 'package:flutter_playground/bloc/cubit2cubit/counter_cubit/counter_cubit.dart';

void main() {
  runApp(Cubit2CubitStream());
}

class Cubit2CubitStream extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MultiBlocProvider(
      providers: [
        BlocProvider<ColorCubit>(create: (context) => ColorCubit()),
        BlocProvider<CounterCubit>(
            create: (context) =>
                CounterCubit(colorCubit: context.read<ColorCubit>())),
      ],
      child: MaterialApp(theme: ThemeData.dark(), home: CubitStream()),
    );
  }
}

class CubitStream extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: context.watch<ColorCubit>().state.color,
      appBar: AppBar(
        title: const Text('Cubit to Cubit'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
                onPressed: () {
                  context.read<ColorCubit>().changeColor();
                },
                child: const Text(
                  'Change Color',
                  style: TextStyle(fontSize: 24),
                )),
            const SizedBox(height: 20),
            Text(
              '${context.watch<CounterCubit>().state.counter}',
              style: const TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: Colors.white),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
                onPressed: () {
                  context.read<CounterCubit>().changeCounter();
                },
                child: const Text(
                  'Counter Increment',
                  style: TextStyle(fontSize: 24),
                ))
          ],
        ),
      ),
    );
  }
}
