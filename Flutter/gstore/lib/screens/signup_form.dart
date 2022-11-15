import 'package:flutter/material.dart';

import '../widgets/button.dart';
import '../widgets/date_picker_input.dart';
import '../widgets/input.dart';

class SignUpScreen extends StatefulWidget {
  const SignUpScreen({Key? key}) : super(key: key);

  @override
  State<SignUpScreen> createState() => _SignUpScreenState();
}

class _SignUpScreenState extends State<SignUpScreen> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
            appBar: AppBar(
              title: const Text("Inscription"),
              backgroundColor: Colors.deepPurple,
            ),
            body: Container(
                padding: const EdgeInsets.all(10),
                child: Center(
                    child: Column(
                  children: [
                    Image.asset("assets/mcdungeons.jpg",
                        height: 300, width: 500),
                    const Input(label: 'Username'),
                    const Input(
                        label: 'Email', keyboard: TextInputType.emailAddress),
                    const Input(label: 'Mot de passe', secure: true),
                    const DatePickerInput(label: 'Année de naissance'),
                    const Input(label: 'Adresse de facturation'),
                    Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: const [
                          Button(content: Text("S'inscrire")),
                          Button(content: Text("Annuler")),
                        ])
                  ],
            )
          )
        )
      )
    );
  }
}
