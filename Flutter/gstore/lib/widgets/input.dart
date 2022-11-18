import 'package:flutter/material.dart';

class Input extends StatefulWidget {
  const Input(
      {this.label, this.secure = false, this.keyboard, super.key, this.action});

  final String? label;
  final bool secure;
  final TextInputType? keyboard;
  final TextInputAction? action;

  @override
  State<Input> createState() => _InputState();
}

class _InputState extends State<Input> {
  TextEditingController inputController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.symmetric(vertical: 10),
      child: Expanded(
        child: TextField(
          textInputAction: widget.action,
          obscureText: widget.secure,
          keyboardType: widget.keyboard,
          controller: inputController,
          decoration: InputDecoration(
            hintText: widget.label,
            focusedBorder: const OutlineInputBorder(
              borderSide: BorderSide(
                color: Colors.deepPurple,
              ),
            ),
            border: const OutlineInputBorder(),
          ),
        ),
      ),
    );
  }
}
