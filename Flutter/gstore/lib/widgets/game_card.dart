import 'package:flutter/material.dart';
import 'package:gstore/screens/game_details.dart';

class GameCard extends StatelessWidget {
  final String _path;
  final String _title;
  final int _price;

  const GameCard(this._path, this._title, this._price, {super.key});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.of(context).push(
          MaterialPageRoute(
            builder: (context) => GameDetails(_path, _title, _price),
          ),
        );
      },
      child: Card(
        child: Row(
          children: [
            Container(
              padding: const EdgeInsets.all(10),
              child: Image.asset(
                _path,
                height: 90,
                width: 180,
              ),
            ),
            Flexible(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(_title,
                      style: const TextStyle(
                          fontSize: 25,
                          color: Colors.indigo,
                          fontWeight: FontWeight.bold)),
                  Text("$_price DT",
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
