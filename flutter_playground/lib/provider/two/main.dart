import 'package:flutter/material.dart';
import 'package:flutter_playground/provider/two/models/dog.dart';
import 'package:provider/provider.dart';

import 'models/babies.dart';

void main() {
  runApp(const DogApp());
}

class DogApp extends StatelessWidget {
  const DogApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(
            create: (BuildContext context) =>
                Dog(name: 'Hello,Dog', breed: 'bull')),
        FutureProvider<int>(
            create: (context) {
              final int age = context.read<Dog>().age;
              final babies = Babies(age: age);
              return babies.getBabies();
            },
            initialData: 0),
        StreamProvider<String>(
            create: (context) {
              final int age = context.read<Dog>().age;
              final babies = Babies(age: age * 2);
              return babies.bark();
            },
            initialData: 'Bark intial 0 times')
      ],
      child: MaterialApp(
          title: 'Couter provider app',
          home: const HomePage(),
          theme: ThemeData(primarySwatch: Colors.amber)),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Dog App')),
      body: Center(
          child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              mainAxisSize: MainAxisSize.min,
              children: <Widget>[
            Text('name: ${context.watch<Dog>().name}'),
            const SizedBox(height: 20),
            BreedAndAge()
          ])),
    );
  }
}

class BreedAndAge extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Column(children: <Widget>[
      Text('breed : ${context.select<Dog, String>((Dog dog) => dog.breed)}'),
      const SizedBox(height: 20),
      const Age()
    ]);
  }
}

class Age extends StatelessWidget {
  const Age({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(children: <Widget>[
      //Text('age: ${Provider.of<Dog>(context).age}'),
      Text('age: ${context.select<Dog, int>((Dog dog) => dog.age)}'),
      const SizedBox(
        height: 20,
      ),
      Text('babies: ${context.read<int>()}'),
      const SizedBox(
        height: 20,
      ),
      Text('Bark: ${context.watch<String>()}'),
      const SizedBox(
        height: 20,
      ),
      ElevatedButton(
        onPressed: () =>
            //Provider.of<Dog>(context, listen: false).grow(),
            context.read<Dog>().grow(),
        child: const Text('Grow'),
      )
    ]);
  }
}