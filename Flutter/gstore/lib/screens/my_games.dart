import 'package:flutter/material.dart';

import '../data/game.dart';
import '../widgets/game_card.dart';

class MyGamesScreen extends StatefulWidget {
  const MyGamesScreen({super.key});

  @override
  State<MyGamesScreen> createState() => _MyGamesScreenState();
}

class _MyGamesScreenState extends State<MyGamesScreen> {
  List<Game> games = [];

  String desc =
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

  @override
  void initState() {
    games.add(Game("", "assets/dmc5.jpg", "Devil May Cry 5", 420, desc, 10));
    games.add(Game("", "assets/fifa.jpg", "FIFA 2022", 320, desc, 19));
    games.add(Game("", "assets/minecraft.webp", "Minecraft", 90, desc, 12));
    games.add(Game("", "assets/nfs.jpg", "Need For Speed", 500, desc, 10));
    games.add(Game("", "assets/rdr2.jpg", "Red Dead Redemption 2", 200, desc, 52));
    games.add(Game("", "assets/re8.jpg", "Resident Evil 8", 250, desc, 12));
    games.add(Game("",
        "assets/skyrim.jpg", "The Elder Scrolls V - Skyrim", 160, desc, 92));

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return GridView.builder(
      gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: 2,
        mainAxisExtent: 210,
        mainAxisSpacing: 5,
        crossAxisSpacing: 5,
      ),
      itemCount: games.length,
      itemBuilder: (context, index) {
        return GameCard(games[index], true);
      },
    );
  }
}
