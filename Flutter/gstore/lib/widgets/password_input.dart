import 'package:flutter/material.dart';

class PasswordInput extends StatefulWidget {
  const PasswordInput({this.label, this.keyboard, super.key, this.action});

  final String? label;
  final TextInputType? keyboard;
  final TextInputAction? action;

  @override
  State<PasswordInput> createState() => _PasswordInputState();
}

class _PasswordInputState extends State<PasswordInput> {
  TextEditingController inputController = TextEditingController();

  bool? visible;
  IconData? icon;

  @override
  void initState() {
    visible = false;
    icon = Icons.visibility;
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.symmetric(vertical: 10),
      child: Expanded(
        child: TextField(
          textInputAction: widget.action,
          obscureText: true,
          keyboardType: widget.keyboard,
          controller: inputController,
          decoration: InputDecoration(
            suffixIcon: Icon(icon),
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
