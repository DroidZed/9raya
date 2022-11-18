import 'package:flutter/material.dart';

import '../data/game.dart';
import '../widgets/game_card.dart';

class GamesList extends StatelessWidget {
  const GamesList({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'G Store',
        home: Scaffold(
          appBar: AppBar(
            title: const Text('G Store'),
            backgroundColor: Colors.deepPurple,
          ),
          body: ListView(
            children: [
              GameCard(Game(
                  path: "assets/dmc5.jpg",
                  title: "Devil May Cry 5",
                  price: 420)),
              GameCard(Game(
                  path: "assets/fifa.jpg", title: "FIFA 2022", price: 320)),
              GameCard(Game(
                  path: "assets/minecraft.webp",
                  title: "Minecraft",
                  price: 90)),
              GameCard(Game(
                  path: "assets/nfs.jpg", title: "Need For Speed", price: 500)),
              GameCard(Game(
                  path: "assets/rdr2.jpg",
                  title: "Red Dead Redemption 2",
                  price: 200)),
              GameCard(Game(
                  path: "assets/re8.jpg",
                  title: "Resident Evil 8",
                  price: 250)),
              GameCard(Game(
                  path: "assets/skyrim.jpg",
                  title: "The Elder Scrolls V - Skyrim",
                  price: 160)),
            ],
          ),
        ));
  }
}
