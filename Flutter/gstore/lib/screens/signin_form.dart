import 'dart:convert';

import 'package:flutter/material.dart';

import 'package:gstore/utils/conts.dart';
import 'package:path/path.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:sqflite/sqflite.dart';

import '../widgets/button.dart';
import '../widgets/input.dart';
import '../widgets/password_input.dart';

import 'package:http/http.dart' as http;

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
                            // Navigator.pushNamed(context, home);
                            Map<String, dynamic> data = {
                              "username": _username,
                              "mdp": _mdp,
                            };
                            Map<String, String> headers = {
                              "Content-Type": "application/json ; charset=UTF-8"
                            };
                            http
                                .post(Uri.parse("$baseUrl/user/signin"),
                                    headers: headers, body: json.encode(data))
                                .then((http.Response response) async {
                              if (response.statusCode == 200) {
                                Map<String, dynamic> user =
                                    json.decode(response.body);

                                SharedPreferences prefs =
                                    await SharedPreferences.getInstance();

                                prefs.setString("user", user["_id"]);

                                Database db = await openDatabase(
                                  join(await getDatabasesPath(), "gstore.db"),
                                  version: 1,
                                  onCreate: (Database db, int version) async {
                                    await db.transaction((txn) => txn.execute(
                                        "CREATE TABLE users (_id TEXT PRIMARY KEY, username TEXT, address TEXT, wallet INTEGER)"));
                                    await db.transaction(((txn) => txn.execute(
                                        "CREATE TABLE basket (_id TEXT PRIMARY KEY, url TEXT, price INTEGER)")));
                                  },
                                );

                                db.insert("users", user,
                                    conflictAlgorithm:
                                        ConflictAlgorithm.replace);

                                // select
                                List<Map<String, dynamic>> users =
                                    await db.query("users");

                                print(users);

                                Navigator.pushNamed(context, homeRoute);
                              } else {
                                showDialog(
                                    context: context,
                                    builder: (BuildContext context) {
                                      return AlertDialog(
                                        title: const Text("Erreur"),
                                        content: const Text(
                                            "Le nom d'utilisateur ou le mot de passe est incorrect!"),
                                        actions: [
                                          TextButton(
                                              onPressed: () =>
                                                  Navigator.pop(context),
                                              child: const Text("OK"))
                                        ],
                                      );
                                    });
                              }
                            });
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
