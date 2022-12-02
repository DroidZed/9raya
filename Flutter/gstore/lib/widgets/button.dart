import 'package:flutter/material.dart';

class Button extends StatelessWidget {
  const Button(
      {required this.content,
      this.padding = 15.5,
      this.onPress,
      this.color,
      super.key});

  final Widget content;
  final double padding;
  final Color? color;
  final void Function()? onPress;

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
        onPressed: onPress,
        style: ButtonStyle(
          backgroundColor:
              MaterialStateProperty.all<Color>(color ?? Colors.deepPurple),
          padding: MaterialStateProperty.all<EdgeInsetsGeometry>(
              EdgeInsets.all(padding)),
        ),
        child: content);
  }
}
