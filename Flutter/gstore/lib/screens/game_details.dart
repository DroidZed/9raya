import 'package:flutter/material.dart';
// import 'package:gstore/screens/signup_form.dart';

import '../data/game.dart';
import '../widgets/button.dart';
import './signup_form.dart';

class GameDetails extends StatefulWidget {
  const GameDetails(this.gameDetails, {super.key});

  final Game gameDetails;

  @override
  State<GameDetails> createState() => _GameDetailsState();
}

class _GameDetailsState extends State<GameDetails> {
  int gameQte = 0;

  @override
  void initState() {
    gameQte = widget.gameDetails.qte;
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text(widget.gameDetails.title),
          backgroundColor: Colors.deepPurple,
        ),
        body: Container(
          padding: const EdgeInsets.symmetric(horizontal: 10),
          child: Column(
            children: [
              Image.asset(widget.gameDetails.path,
                  height: 300, width: double.maxFinite),
              Text(
                widget.gameDetails.description,
                style:
                    const TextStyle(fontSize: 16, fontWeight: FontWeight.w400),
              ),
              Container(
                margin: const EdgeInsets.symmetric(vertical: 50),
                child: Column(
                  children: [
                    Text(
                      "${widget.gameDetails.price} DT",
                      style: const TextStyle(
                          fontSize: 25, fontWeight: FontWeight.w700),
                    ),
                    Text(
                      gameQte > 0 ? "Examplaires: $gameQte" : "Hors stock",
                      style: const TextStyle(
                          fontSize: 16, fontWeight: FontWeight.w400),
                    ),
                  ],
                ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  Button(
                      content: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: const [
                          Icon(Icons.shopping_cart),
                          Text("Acheter"),
                        ],
                      ),
                      onPress: () {
                        setState(() {
                          gameQte--;
                        });
                      }),
                  Button(
                      content: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: const [
                          Icon(Icons.app_registration),
                          Text("S'inscrire"),
                        ],
                      ),
                      onPress: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => const SignUpScreen()),
                        );
                      })
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}
