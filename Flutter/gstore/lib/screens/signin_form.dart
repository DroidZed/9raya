import 'package:flutter/material.dart';

import 'package:gstore/utils/conts.dart';

import '../widgets/button.dart';
import '../widgets/input.dart';
import '../widgets/password_input.dart';

class SignInScreen extends StatefulWidget {
  const SignInScreen({super.key});

  @override
  State<SignInScreen> createState() => _SignInScreenState();
}

class _SignInScreenState extends State<SignInScreen> {
  String? _username;
  String? _mdp;

  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: true,
      appBar: AppBar(
        title: const Text("S'authentifier"),
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
                    PasswordInput(
                      action: TextInputAction.done,
                      label: 'Mot de passe',
                      onSaved: (newValue) => _mdp = newValue,
                      validator: (String? value) =>
                          (value == null || value.isEmpty)
                              ? "Le mot de passe ne doit pas être vide!"
                              : null,
                    ),
                    Container(
                      margin: const EdgeInsets.symmetric(vertical: 10),
                      width: double.infinity,
                      child: Button(
                        color: Colors.blue,
                        content: const Text("S'authentifier"),
                        onPress: () {
                          if (_formKey.currentState!.validate()) {
                            _formKey.currentState!.save();
                            Navigator.pushNamed(context, home);
                          }
                        },
                      ),
                    ),
                    Container(
                      margin: const EdgeInsets.symmetric(vertical: 10),
                      width: double.infinity,
                      child: Button(
                        color: Colors.pinkAccent,
                        content: const Text("S'inscrire"),
                        onPress: () =>
                            Navigator.pushNamed(context, signUpRoute),
                      ),
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        const Text("Mot de passe oublié ?"),
                        TextButton(
                          onPressed: () =>
                              Navigator.pushNamed(context, forgetPasswordRoute),
                          child: const Text("Cliquez ici"),
                        )
                      ],
                    )
                  ],
                ),
              ))),
    );
  }
}
