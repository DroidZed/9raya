import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

import '../widgets/button.dart';
import '../widgets/date_picker_input.dart';
import '../widgets/input.dart';
import '../widgets/password_input.dart';

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
            resizeToAvoidBottomInset: true,
            appBar: AppBar(
              title: const Text("Inscription"),
              backgroundColor: Colors.deepPurple,
            ),
            body: Container(
                padding: const EdgeInsets.symmetric(horizontal: 10),
                child: Center(
                    child: SingleChildScrollView(
                  child: Column(
                    children: [
                      Image.asset("assets/mcdungeons.jpg",
                          height: 200, width: double.maxFinite),
                      const Input(
                          action: TextInputAction.next, label: 'Username'),
                      const Input(
                          action: TextInputAction.next,
                          label: 'Email',
                          keyboard: TextInputType.emailAddress),
                      const PasswordInput(
                          action: TextInputAction.next, label: 'Mot de passe'),
                      const DatePickerInput(label: 'Année de naissance'),
                      const Input(
                          action: TextInputAction.done,
                          label: 'Adresse de facturation'),
                      Container(
                        margin: const EdgeInsets.only(top: 50),
                        child: Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              Container(
                                margin: const EdgeInsets.only(right: 10),
                                child: Button(
                                  content: const Text("S'inscrire"),
                                  onPress: () {
                                    if (kDebugMode) {
                                      print("hey ");
                                    }
                                  },
                                ),
                              ),
                              Container(
                                margin: const EdgeInsets.only(left: 10),
                                child: Button(
                                    content: const Text("Annuler"),
                                    onPress: () {
                                      if (kDebugMode) {
                                        print("hey ");
                                      }
                                    }),
                              ),
                            ]),
                      )
                    ],
                  ),
                )))));
  }
}
