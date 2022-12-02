import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class DatePickerInput extends StatefulWidget {
  DatePickerInput({this.label, this.validator, this.onSaved, super.key});

  final String? label;
  void Function(String?)? onSaved;
  String? Function(String?)? validator;

  @override
  State<DatePickerInput> createState() => _DatePickerInputState();
}

class _DatePickerInputState extends State<DatePickerInput> {
  TextEditingController inputController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Container(
        margin: const EdgeInsets.symmetric(vertical: 10),
        child: Expanded(
            child: TextFormField(
          onSaved: widget.onSaved,
          validator: widget.validator,
          controller: inputController,
          readOnly: true,
          onTap: () async {
            DateTime? pickedDate = await showDatePicker(
                builder: (BuildContext context, Widget? child) {
                  return Theme(
                    data: ThemeData.light().copyWith(
                      colorScheme: const ColorScheme.light(
                        primary: Colors.deepPurple,
                      ),
                      buttonTheme: const ButtonThemeData(
                        textTheme: ButtonTextTheme.primary,
                      ),
                    ),
                    child: child!,
                  );
                },
                context: context,
                //context of current state
                initialDate: DateTime.now(),
                firstDate: DateTime(1970),
                //DateTime.now() - not to allow to choose before today.
                lastDate: DateTime(2101));

            inputController.text = pickedDate != null
                ? DateFormat('dd-MM-yyyy').format(pickedDate)
                : '';
          },
          decoration: InputDecoration(
            hintText: widget.label,
            focusedBorder: const OutlineInputBorder(
              borderSide: BorderSide(
                color: Colors.deepPurple,
              ),
            ),
            border: const OutlineInputBorder(),
          ),
        )));
  }
}
