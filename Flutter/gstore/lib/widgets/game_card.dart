import 'package:flutter/material.dart';
import 'package:gstore/utils/conts.dart';

import '../data/game.dart';

class GameCard extends StatelessWidget {
  final Game gameData;
  final bool isInGrid;

  const GameCard(this.gameData, this.isInGrid, {super.key});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onTap: () => Navigator.pushNamed(context, gameDetailsRoute),
        child: Card(
            child: Flexible(
          flex: 1,
          child: Flex(
              direction: isInGrid ? Axis.vertical : Axis.horizontal,
              mainAxisSize: MainAxisSize.min,
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                Container(
                  padding: const EdgeInsets.all(10),
                  child: Image.asset(
                    gameData.imagePath,
                    height: 90,
                    width: 180,
                  ),
                ),
                Flexible(
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: !isInGrid
                        ? CrossAxisAlignment.start
                        : CrossAxisAlignment.center,
                    children: [
                      Text(gameData.title,
                          softWrap: true,
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
              ]),
        )));
  }
}
