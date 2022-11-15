import 'package:flutter/material.dart';
import 'package:gstore/screens/signup_form.dart';

import '../widgets/button.dart';

class GameDetails extends StatelessWidget {
  const GameDetails(this._image, this._title, this._price, {super.key});

  final String _image;
  final String _title;
  final int _price;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text(_title),
          backgroundColor: Colors.deepPurple,
        ),
        body: Container(
          padding: const EdgeInsets.all(10),
          child: Column(
            children: [
              Image.asset(_image, height: 300, width: 500),
              const Text(
                  style: TextStyle(fontSize: 16, fontWeight: FontWeight.w400),
                  "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
              Text(
                "$_price DT",
                style:
                    const TextStyle(fontSize: 25, fontWeight: FontWeight.w400),
              ),
              Button(
                  content: const Text("Acheter"),
                  onPress: () {
                    Navigator.of(context).push(
                      MaterialPageRoute(
                        builder: (context) => const SignUpScreen(),
                      ),
                    );
                  })
            ],
          ),
        ),
      ),
    );
  }
}
