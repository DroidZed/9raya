import 'package:flutter/material.dart';
import 'package:gstore/navigation/tab_bar_nav.dart';
import 'package:gstore/screens/signin_form.dart';
import 'package:gstore/utils/conts.dart';

import 'navigation/bottom_nav_bar.dart';
import 'screens/cart.dart';
import 'screens/forget_password.dart';
import 'screens/game_details_arguments.dart';
import 'screens/profile_settings.dart';
import 'screens/signup_form.dart';

void main() {
  runApp(
    MaterialApp(
      color: Colors.white70,
      home: const SignInScreen(),
      routes: {
        signUpRoute: (context) => const SignUpScreen(),
        profileRoute: (context) => const ProfileSettingsScreen(),
        cartRoute: (context) => const CartScreen(),
        forgetPasswordRoute: (context) => const ForgetPasswordScreen(),
        home: (context) => const TabBarNav(),
        bottomNavBarRoute: (context) => const BottomNavBar(),
        gameDetailsRoute: (context) => const ExtractGameDetailsArguments(),
      },
    ),
  );
}
