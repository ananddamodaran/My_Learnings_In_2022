import 'package:flutter/material.dart';

void main() {
  runApp(const CounterApp());
}

class CounterApp extends StatelessWidget {
  const CounterApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Couter provider app',
        home: const HomePage(),
        theme: ThemeData(primarySwatch: Colors.amber));
  }
}

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int counter = 0;
  void increment() {
    setState(() {
      counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Counter Provider app'),
      ),
      body: Center(
        child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Container(color: Colors.blue, child: const Text('MyHomePage')),
              const SizedBox(height: 20),
              CounterA(counter: counter, increment: increment),
              const SizedBox(height: 20),
              BottomWidget(counter: counter),
            ]),
      ),
    );
  }
}

class CounterA extends StatelessWidget {
  final int counter;
  final void Function() increment;
  const CounterA({Key? key, required this.counter, required this.increment})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.green,
        child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Column(children: <Widget>[
            Text('$counter'),
            ElevatedButton(onPressed: increment, child: const Text('Increment'))
          ]),
        ));
  }
}

class BottomWidget extends StatelessWidget {
  final int counter;
  const BottomWidget({Key? key, required this.counter}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.orange,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          mainAxisSize: MainAxisSize.min,
          children: [Text('$counter'), SizedBox(width: 20), Text('Sibling')],
        ));
  }
}
