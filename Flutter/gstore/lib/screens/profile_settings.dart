import 'package:flutter/material.dart';
import 'package:gstore/utils/conts.dart';

import '../widgets/button.dart';
import '../widgets/input.dart';
import '../widgets/password_input.dart';

class ProfileSettingsScreen extends StatefulWidget {
  const ProfileSettingsScreen({super.key});

  @override
  State<ProfileSettingsScreen> createState() => _ProfileSettingsScreenState();
}

class _ProfileSettingsScreenState extends State<ProfileSettingsScreen> {
  String? _actualPwd;
  String? _newPwd;
  String? _addr;

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
                    PasswordInput(
                      action: TextInputAction.next,
                      label: 'Mot de passe actuel',
                      onSaved: (newValue) => _actualPwd = newValue,
                      validator: (String? value) =>
                          (value == null || value.isEmpty || value.length < 8)
                              ? "Le mot de passe ne doit pas être vide!"
                              : null,
                    ),
                    PasswordInput(
                      action: TextInputAction.next,
                      label: 'Nouveau mot de passe',
                      onSaved: (newValue) => _newPwd = newValue,
                      validator: (String? value) =>
                          (value == null || value.isEmpty || value.length < 8)
                              ? "Le mot de passe ne doit pas être vide!"
                              : null,
                    ),
                    Input(
                      maxLines: 5,
                      action: TextInputAction.done,
                      label: 'Adresse de facturation',
                      onSaved: (newValue) => _addr = newValue,
                      validator: (String? value) =>
                          (value == null || value.isEmpty)
                              ? "L'adresse ne doit pas être vide!"
                              : null,
                    ),
                    Button(
                      content: const Text("Enregistrer"),
                      onPress: () {
                        if (_formKey.currentState!.validate()) {
                          _formKey.currentState!.save();
                          Navigator.pushNamed(context, cartRoute);
                        }
                      },
                    ),
                  ],
                ),
              )),
        ));
  }
}
