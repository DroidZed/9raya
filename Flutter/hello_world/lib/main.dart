import 'package:flutter/material.dart';

void main() {

  runApp(const HomePage());
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: "Esprit 4SIM3",
        home: Scaffold(
          appBar: AppBar(
            title: const Text("Hello World"),
          ),
          body: const Center(
            child: Text(
              style: TextStyle(color: Color(0x005865F2), fontSize: 32, decoration: TextDecoration.underline),
                "Hello World !"),
          ),
        ),
    );
  }

}