import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class DatePickerInput extends StatefulWidget {
  const DatePickerInput({this.label, super.key});

  final String? label;

  @override
  State<DatePickerInput> createState() => _DatePickerInputState();
}

class _DatePickerInputState extends State<DatePickerInput> {
  TextEditingController inputController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return TextField(
      controller: inputController,
      readOnly: true,
      onTap: () async {
        DateTime? pickedDate = await showDatePicker(
            context: context,
            //context of current state
            initialDate: DateTime.now(),
            firstDate: DateTime(2000),
            //DateTime.now() - not to allow to choose before today.
            lastDate: DateTime(2101));

        inputController.text = pickedDate != null
            ? DateFormat('dd-MM-yyyy').format(pickedDate)
            : '';
      },
      decoration: InputDecoration(
        border: const OutlineInputBorder(),
        hintText: widget.label,
      ),
    );
  }
}
