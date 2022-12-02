import 'package:flutter/material.dart';

import 'package:gstore/utils/conts.dart';

import '../widgets/button.dart';
import '../widgets/input.dart';

class ForgetPasswordScreen extends StatefulWidget {
  const ForgetPasswordScreen({super.key});

  @override
  State<ForgetPasswordScreen> createState() => _ForgetPasswordScreenState();
}

class _ForgetPasswordScreenState extends State<ForgetPasswordScreen> {
  String? _username;
  // String? _email;

  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: true,
      appBar: AppBar(
        title: const Text("Réinitialiser le mot de passe"),
        backgroundColor: Colors.deepPurple,
      ),
      body: Container(
          padding: const EdgeInsets.symmetric(horizontal: 10),
          child: Form(
              key: _formKey,
              child: SingleChildScrollView(
                child: Column(
                  children: [
                    Image.asset("assets/mcdungeons.jpg",
                        height: 200, width: 300),
                    Input(
                      label: 'Username',
                      action: TextInputAction.next,
                      onSaved: (newValue) => _username = newValue,
                      validator: (String? value) =>
                          (value == null || value.isEmpty)
                              ? "Le nom d'utilisateur ne doit pas être vide!"
                              : null,
                    ),
                    Button(
                      content: const Text("Réinitialiser le mot de passe"),
                      onPress: () {
                        if (_formKey.currentState!.validate()) {
                          _formKey.currentState!.save();
                          Navigator.pushNamed(context, profileRoute);
                        }
                      },
                    ),
                  ],
                ),
              ))),
    );
  }
}
