import 'package:flutter/material.dart';

import '../utils/game_setails_screen_arguments.dart';
import 'game_details.dart';

class ExtractGameDetailsArguments extends StatelessWidget {
  const ExtractGameDetailsArguments({super.key});

  @override
  Widget build(BuildContext context) {
    final args = ModalRoute.of(context)!.settings.arguments
        as GameDetailsScreenArguments;

    return GameDetailsScreen(args.game);
  }
}
