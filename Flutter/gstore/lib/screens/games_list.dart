import 'package:flutter/material.dart';

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
            children: const [
              GameCard("assets/dmc5.jpg", "Devil May Cry 5", 420),
              GameCard("assets/fifa.jpg", "FIFA 2022", 320),
              GameCard("assets/minecraft.webp", "Minecraft", 90),
              GameCard("assets/nfs.jpg", "Need For Speed", 500),
              GameCard("assets/rdr2.jpg", "Red Dead Redemption 2", 200),
              GameCard("assets/re8.jpg", "Resident Evil 8", 250),
              GameCard(
                  "assets/skyrim.jpg", "The Elder Scrolls V - Skyrim", 160),
            ],
          ),
        ));
  }
}
