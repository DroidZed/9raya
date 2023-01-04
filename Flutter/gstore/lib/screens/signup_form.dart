import 'package:flutter/material.dart';
import 'package:gstore/screens/cart.dart';
import 'package:gstore/utils/conts.dart';

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
  String? _username;
  String? _email;
  String? _mdp;
  String? _addr;
  String? _annee;

  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        resizeToAvoidBottomInset: true,
        appBar: AppBar(
          title: const Text("Inscription"),
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
                      validator: (String? value) => (value == null ||
                              value.isEmpty ||
                              value.length < 5 ||
                              value.contains(" "))
                          ? "Veuillez entrer un nom d'utilisateur"
                          : null,
                    ),
                    Input(
                      action: TextInputAction.next,
                      label: 'Email',
                      keyboard: TextInputType.emailAddress,
                      onSaved: (newValue) => _email = newValue,
                      validator: (String? value) => (value == null ||
                              value.isEmpty ||
                              !RegExp(r"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$")
                                  .hasMatch(value))
                          ? "Veuillez entrer un email valide"
                          : null,
                    ),
                    PasswordInput(
                      action: TextInputAction.next,
                      label: 'Mot de passe',
                      onSaved: (newValue) => _mdp = newValue,
                      validator: (String? value) =>
                          (value == null || value.isEmpty || value.length < 8)
                              ? "Veuillez entrer un mot de passe valide"
                              : null,
                    ),
                    DatePickerInput(
                      label: 'Date de naissance',
                      onSaved: (newValue) => _annee = newValue,
                      validator: (String? value) =>
                          (value == null || value.isEmpty)
                              ? "Veuillez entrer une date de naissance valide"
                              : null,
                    ),
                    Input(
                      maxLines: 5,
                      action: TextInputAction.done,
                      label: 'Adresse de facturation',
                      onSaved: (newValue) => _addr = newValue,
                      validator: (String? value) =>
                          (value == null || value.isEmpty)
                              ? "Veuillez entrer une adresse valide"
                              : null,
                    ),
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
                                  if (_formKey.currentState!.validate()) {
                                    _formKey.currentState!.save();
                                    Navigator.pushNamed(context, homeRoute);
                                  }
                                },
                              ),
                            ),
                            Container(
                              margin: const EdgeInsets.only(left: 10),
                              child: Button(
                                  content: const Text("Annuler"),
                                  onPress: () {
                                    _formKey.currentState!.reset();
                                    Navigator.of(context).pop();
                                  }),
                            ),
                          ]),
                    )
                  ],
                ),
              )),
        ));
  }
}
