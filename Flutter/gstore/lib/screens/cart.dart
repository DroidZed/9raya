import 'package:flutter/material.dart';

import 'package:gstore/data/cart_data.dart';
import 'package:gstore/widgets/cart_item.dart';

class CartScreen extends StatefulWidget {
  const CartScreen({super.key});

  @override
  State<CartScreen> createState() => _CartScreenState();
}

class _CartScreenState extends State<CartScreen> {
  double totalPrice = 0;

  List<CartData> cartItems = [];

  @override
  void initState() {
    cartItems.add(CartData("assets/dmc5.jpg", 420));
    cartItems.add(CartData("assets/fifa.jpg", 320));
    cartItems.add(CartData("assets/minecraft.webp", 90));
    cartItems.add(CartData("assets/nfs.jpg", 500));
    cartItems.add(CartData(
      "assets/rdr2.jpg",
      200,
    ));
    cartItems.add(CartData("assets/re8.jpg", 250));
    cartItems.add(CartData("assets/skyrim.jpg", 160));
    cartItems.add(CartData("assets/mcdungeons.jpg", 110));

    totalPrice = cartItems.fold(0, (sum, item) => sum + item.price);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        Container(
          width: double.infinity,
          margin: const EdgeInsets.all(10),
          child: Text(
            textAlign: TextAlign.end,
            "Total: $totalPrice",
            style: const TextStyle(fontSize: 20),
          ),
        ),
        const Divider(
          endIndent: 10,
          indent: 10,
          thickness: 2,
        ),
        Flexible(
          child: ListView.builder(
            shrinkWrap: true,
            itemCount: cartItems.length,
            itemBuilder: (context, index) {
              return CartItem(cartItems[index], () {
                setState(() {
                  totalPrice -= cartItems[index].price;
                  cartItems.removeAt(index);
                });
              });
            },
          ),
        ),
      ],
    );
  }
}
