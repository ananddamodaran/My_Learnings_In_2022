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
      body: Consumer<Dog>(
        builder: (BuildContext context, Dog dog, Widget? child) {
          print('I like dogs very much');
          return Center(
              child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  mainAxisSize: MainAxisSize.min,
                  children: <Widget>[
                child!,
                const SizedBox(height: 20),
                Text('name: ${dog.name}'),
                const SizedBox(height: 20),
                BreedAndAge()
              ]));
        },
        child: const Text('I like dogs very much'),
      ),
    );
  }
}

class BreedAndAge extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Consumer<Dog>(builder: (_, Dog dog, __) {
      return Column(children: <Widget>[
        Text('breed : ${dog.breed}'),
        const SizedBox(height: 20),
        const Age()
      ]);
    });
  }
}

class Age extends StatelessWidget {
  const Age({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Consumer<Dog>(builder: (_, Dog dog, __) {
      return Column(children: <Widget>[
        Text('age: ${dog.age}'),
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
          onPressed: () => dog.grow(),
          child: const Text('Grow'),
        )
      ]);
    });
  }
}
