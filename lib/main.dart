import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: screen_saver(),
  ));
}

class screen_saver extends StatefulWidget {
  const screen_saver({super.key});

  @override
  State<screen_saver> createState() => _screen_saverState();
}

class _screen_saverState extends State<screen_saver> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text("This is Screen-saver app"),
      ),
    );
  }
}
