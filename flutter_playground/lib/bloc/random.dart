import 'dart:math';

import 'package:flutter/material.dart';

class RandomNumber extends StatelessWidget {
  const RandomNumber({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Random Number'),
      ),
      body: Center(
        child: ElevatedButton(
          child: const Text(
            'Change Theme',
            style: TextStyle(fontSize: 24),
          ),
          onPressed: () {
            final randomInt = Random().nextInt(10);
            print(randomInt);
          },
        ),
      ),
    );
  }
}
