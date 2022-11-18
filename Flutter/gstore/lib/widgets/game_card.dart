import 'package:flutter/material.dart';
import 'package:gstore/screens/game_details.dart';

import '../data/game.dart';

class GameCard extends StatelessWidget {
  final Game gameData;

  const GameCard(this.gameData, {super.key});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.of(context).push(
          MaterialPageRoute(
            builder: (context) =>
                GameDetails(gameData.path, gameData.title, gameData.price),
          ),
        );
      },
      child: Card(
        child: Row(
          children: [
            Container(
              padding: const EdgeInsets.all(10),
              child: Image.asset(
                gameData.path,
                height: 90,
                width: 180,
              ),
            ),
            Flexible(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(gameData.title,
                      style: const TextStyle(
                          fontSize: 25,
                          color: Colors.indigo,
                          fontWeight: FontWeight.bold)),
                  Text("${gameData.price} DT",
                      style: const TextStyle(
                          fontSize: 20, fontWeight: FontWeight.w400))
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}
