import 'package:flutter/material.dart';
import 'package:gstore/screens/cart.dart';
import 'package:gstore/screens/games_list.dart';

import '../screens/my_games.dart';
import '../utils/conts.dart';

class BottomNavBar extends StatefulWidget {
  const BottomNavBar({super.key});

  @override
  State<BottomNavBar> createState() => _BottomNavBarState();
}

class _BottomNavBarState extends State<BottomNavBar> {
  int _selectedIndex = 0;

  static const List<Widget> _widgetOptions = <Widget>[
    GamesList(),
    MyGamesScreen(),
    CartScreen()
  ];

  @override
  void setState(VoidCallback fn) {
    super.setState(fn);
  }

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 3,
      child: Scaffold(
          appBar: AppBar(
            title: const Text("G Store"),
            backgroundColor: Colors.deepPurple,
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
                onTap: () => Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => const BottomNavBar())),
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
            ],
          )),
          bottomNavigationBar: BottomNavigationBar(
              currentIndex: _selectedIndex,
              selectedItemColor: Colors.white,
              unselectedItemColor: Colors.white70,
              backgroundColor: Colors.deepPurple,
              items: const [
                BottomNavigationBarItem(icon: Icon(Icons.home), label: "Home"),
                BottomNavigationBarItem(
                    icon: Icon(Icons.games), label: "My Games"),
                BottomNavigationBarItem(
                    icon: Icon(Icons.shopping_cart), label: "Cart"),
              ],
              onTap: (int index) {
                setState(() {
                  _selectedIndex = index;
                });
              }),
          body: _widgetOptions[_selectedIndex]),
    );
  }
}
