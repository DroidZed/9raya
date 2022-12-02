import 'package:flutter/material.dart';

import '../data/cart_data.dart';

class CartItem extends StatelessWidget {
  const CartItem(
    this.cartData,
    this.delBtnOnPress, {
    super.key,
  });

  final CartData cartData;
  final void Function()? delBtnOnPress;

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 10),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            IconButton(
              icon: const Icon(Icons.delete),
              onPressed: delBtnOnPress,
            ),
            Container(
              margin: const EdgeInsets.symmetric(horizontal: 10),
              child: Image.asset(
                cartData.image,
                height: 90,
                width: 180,
              ),
            ),
            Expanded(
              child: Text(
                  style: const TextStyle(
                    fontSize: 30,
                  ),
                  "${cartData.price} TND"),
            ),
          ],
        ),
      ),
    );
  }
}
