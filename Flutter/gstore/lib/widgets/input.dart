import 'package:flutter/material.dart';

class Input extends StatefulWidget {
  const Input({this.label, this.secure = false, this.keyboard, super.key});

  final String? label;
  final bool secure;
  final TextInputType? keyboard;

  @override
  State<Input> createState() => _InputState();
}

class _InputState extends State<Input> {
  TextEditingController inputController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return TextField(
      obscureText: widget.secure,
      keyboardType: widget.keyboard,
      controller: inputController,
      decoration: InputDecoration(
        border: const OutlineInputBorder(),
        hintText: widget.label,
      ),
    );
  }
}
