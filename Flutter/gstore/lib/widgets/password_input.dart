import 'package:flutter/material.dart';

class PasswordInput extends StatefulWidget {
  PasswordInput({
    this.label,
    this.keyboard,
    this.validator,
    this.onSaved,
    this.action,
    super.key,
  });

  final String? label;
  final TextInputType? keyboard;
  final TextInputAction? action;
  void Function(String?)? onSaved;
  String? Function(String?)? validator;

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
        child: TextFormField(
          onSaved: widget.onSaved,
          validator: widget.validator,
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
