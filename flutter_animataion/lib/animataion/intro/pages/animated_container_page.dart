import 'dart:math';

import 'package:flutter/material.dart';

class AnimatedContainerPage extends StatefulWidget {
  @override
  _AnimatedContainerPageState createState() => _AnimatedContainerPageState();
}

class _AnimatedContainerPageState extends State<AnimatedContainerPage> {
  // Define the various properties with default values. Update these properties
  // when the user taps a FloatingActionButton.
  double _width = 200;
  double _height = 200;
  Color _color = Colors.red;
  BorderRadiusGeometry _borderRadius = BorderRadius.circular(16);

  // Create a random number generator.
  final random = Random();

  void _randomize() {
    setState(() {
      // Generate a random width and height.
      _width = random.nextInt(300).toDouble();
      _height = random.nextInt(300).toDouble();

      // Generate a random color.
      _color = Color.fromRGBO(
        random.nextInt(256),
        random.nextInt(256),
        random.nextInt(256),
        1,
      );

      // Generate a random border radius.
      _borderRadius = BorderRadius.circular(random.nextInt(100).toDouble());
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('AnimatedContainer'),
      ),
      body: Center(
        child: AnimatedContainer(
          // Use the properties stored in the State class.
          width: _width,
          height: _height,
          decoration: BoxDecoration(
            color: _color,
            borderRadius: _borderRadius,
          ),
          // Define how long the animation should take.
          duration: Duration(seconds: 1),
          // Provide an optional curve to make the animation feel smoother.
          curve: Curves.fastOutSlowIn, // fastOutSlowIn
        ),
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.play_arrow),
        // When the user taps the button
        onPressed: _randomize,
      ),
    );
  }
}
