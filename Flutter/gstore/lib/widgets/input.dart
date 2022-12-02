import 'package:flutter/material.dart';

class Input extends StatefulWidget {
  Input({
    this.label,
    this.secure = false,
    this.maxLines = 1,
    this.keyboard,
    this.action,
    this.onSaved,
    this.validator,
    super.key,
  });

  final String? label;
  final bool secure;
  final int maxLines;
  final TextInputType? keyboard;
  final TextInputAction? action;
  String? Function(String?)? validator;
  void Function(String?)? onSaved;

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
        child: TextFormField(
          onSaved: widget.onSaved,
          maxLines: widget.maxLines,
          validator: widget.validator,
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
