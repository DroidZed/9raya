import 'package:flutter/material.dart';

class Button extends StatelessWidget {
  const Button(
      {required this.content, this.padding = 15.5, this.onPress, super.key});

  final Widget content;
  final double padding;
  final void Function()? onPress;

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
        onPressed: onPress,
        style: ButtonStyle(
          foregroundColor: MaterialStateProperty.all<Color>(Colors.deepPurple),
          padding: MaterialStateProperty.all<EdgeInsetsGeometry>(
              EdgeInsets.all(padding)),
        ),
        child: content);
  }
}
