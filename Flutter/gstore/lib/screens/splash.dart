import 'package:flutter/material.dart';
import 'package:gstore/screens/games_list.dart';
import 'package:gstore/screens/signin_form.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../utils/conts.dart';

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  late String route;
  late Future<bool> session;

  Future<bool> getSession() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    if (prefs.containsKey("userId")) {
      route = homeRoute;
      return true;
    } else {
      route = "singIn";
    }

    return true;
  }

  @override
  void initState() {
    session = getSession();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: session,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            if (route == homeRoute) {
              return const GamesList();
            } else {
              return const SignInScreen();
            }
          } else {
            return const Center(child: CircularProgressIndicator());
          }
        });
  }
}
