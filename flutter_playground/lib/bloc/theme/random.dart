import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_playground/bloc/theme/cubit/theme_cubit.dart';

class RandomNumber extends StatelessWidget {
  const RandomNumber({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Random Number',
        ),
      ),
      body: Center(
        child: ElevatedButton(
            child: const Text(
              'Change Theme',
              style: TextStyle(fontSize: 26),
            ),
            onPressed: () {
              final randomInt = Random().nextInt(10);
              print(randomInt);
              // context
              //     .read<ThemeBloc>()
              //     .add(ChangeThemeEvent(randomInt: randomInt));
              context.read<ThemeCubit>().changeTheme(randomInt);
            }),
      ),
    );
  }
}
