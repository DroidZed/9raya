import 'package:flutter/material.dart';
import 'package:gstore/screens/cart.dart';
import 'package:gstore/screens/games_list.dart';

import '../screens/my_games.dart';
import '../utils/conts.dart';

class TabBarNav extends StatelessWidget {
  const TabBarNav({super.key});

  static const List<Widget> _widgetOptions = <Widget>[
    GamesList(),
    MyGamesScreen(),
    CartScreen()
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 3,
      child: Scaffold(
          appBar: AppBar(
            title: const Text("G Store"),
            backgroundColor: Colors.deepPurple,
            bottom: const TabBar(
              tabs: [
                Tab(
                  icon: Icon(Icons.home),
                  text: "Home",
                ),
                Tab(
                  icon: Icon(Icons.games),
                  text: "My Games",
                ),
                Tab(
                  icon: Icon(Icons.shopping_cart),
                  text: "Cart",
                ),
              ],
            ),
          ),
          drawer: Drawer(
              child: Column(
            children: [
              const UserAccountsDrawerHeader(
                  decoration: BoxDecoration(color: Colors.deepPurple),
                  currentAccountPicture: CircleAvatar(
                    backgroundImage: AssetImage("assets/minecraft.webp"),
                  ),
                  accountName: Text("Aymen"),
                  accountEmail: Text("my mail")),
              ListTile(
                trailing: const Icon(Icons.arrow_forward),
                title: Row(
                  children: const [
                    Icon(Icons.home),
                    SizedBox(width: 10),
                    Text("Games"),
                  ],
                ),
                onTap: () => Navigator.push(context,
                    MaterialPageRoute(builder: (context) => const TabBarNav())),
              ),
              ListTile(
                title: Row(
                  children: const [
                    Icon(Icons.person),
                    SizedBox(width: 10),
                    Text("Profile"),
                  ],
                ),
                onTap: () => Navigator.pushNamed(context, profileRoute),
              ),
              ListTile(
                title: Row(
                  children: const [
                    Icon(Icons.menu),
                    SizedBox(width: 10),
                    Text("Bottom Nav Bar"),
                  ],
                ),
                onTap: () => Navigator.pushNamed(context, bottomNavBarRoute),
              ),
            ],
          )),
          body: const TabBarView(children: _widgetOptions)),
    );
  }
}
