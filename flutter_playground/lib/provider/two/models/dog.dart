import 'package:flutter/cupertino.dart';

class Dog with ChangeNotifier {
  final String name;
  final String breed;
  int age;

  Dog({required this.name, required this.breed, this.age = 3});

  grow() {
    age++;
    notifyListeners();
  }
}
