import 'package:flutter/material.dart';

class SecondPage extends StatelessWidget {
  final int value;
  const SecondPage({Key? key, required this.value}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(child: Text('$value'));
  }
}
