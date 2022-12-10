import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:gstore/utils/conts.dart';

import '../data/game.dart';
import '../widgets/game_card.dart';

import 'package:http/http.dart' as http;

class GamesList extends StatefulWidget {
  const GamesList({Key? key}) : super(key: key);

  @override
  State<GamesList> createState() => _GamesListState();
}

class _GamesListState extends State<GamesList> {
  List<Game> games = [];

  Future<bool> getGames() async {
    http.Response resp = await http.get(Uri.http(baseUrl, "/game"));
    List<dynamic> gamesJson = json.decode(resp.body);

    if (gamesJson.isEmpty) return false;

    for (dynamic element in gamesJson) {
      games.add(Game(
          element["_id"],
          element["image"],
          element["title"],
          int.parse(element["price"]),
          element["description"],
          int.parse(element["quantity"])));
    }
    return true;
  }

  @override
  void initState() {
    getGames();

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: getGames(),
        builder: (BuildContext context, AsyncSnapshot<bool> snapshot) {
          if (snapshot.hasData) {
            return ListView.builder(
              itemCount: games.length,
              itemBuilder: (context, index) {
                return GameCard(games[index], false);
              },
            );
          } else {
            return const CircularProgressIndicator();
          }
        });
  }
}
