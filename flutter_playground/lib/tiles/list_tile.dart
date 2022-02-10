import 'package:flutter/material.dart';

void main() {
  runApp(ListTileApp());
}

class ListTileApp extends StatelessWidget {
  const ListTileApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'ListTile Page',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const ListTilesWidget(),
    );
  }
}

class ListTilesWidget extends StatefulWidget {
  const ListTilesWidget({Key? key}) : super(key: key);

  @override
  _ListTilesWidgetState createState() => _ListTilesWidgetState();
}

class _ListTilesWidgetState extends State<ListTilesWidget> {
  final List<String> names = <String>[
    'Aby',
    'Aish',
    'Ayan',
    'Ben',
    'Bob',
    'Charlie',
    'Cook',
    'Carline'
  ];
  final List<int> msgCount = <int>[2, 0, 10, 6, 52, 4, 0, 2];
  TextEditingController nameController = TextEditingController();

  void addItemToList() {
    setState(() {
      names.insert(0, nameController.text);
      msgCount.insert(0, 0);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('ListTile'),
      ),
      body: Column(children: <Widget>[
        Padding(
          padding: const EdgeInsets.all(20),
          child: TextField(
            controller: nameController,
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Contact Name',
            ),
          ),
        ),
        ElevatedButton(
          child: const Text('Add'),
          onPressed: () {
            addItemToList();
          },
        ),
        Expanded(
            child: ListView.builder(
                padding: const EdgeInsets.all(8),
                itemCount: names.length,
                itemBuilder: (BuildContext context, int index) {
                  return Container(
                    height: 50,
                    margin: const EdgeInsets.all(2),
                    color: msgCount[index] >= 10
                        ? Colors.blue[400]
                        : msgCount[index] > 3
                            ? Colors.blue[100]
                            : Colors.grey,
                    child: Center(
                        child: Text(
                      '${names[index]} (${msgCount[index]})',
                      style: const TextStyle(fontSize: 18),
                    )),
                  );
                }))
      ]),
    );
  }
}
