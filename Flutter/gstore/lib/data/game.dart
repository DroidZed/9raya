class Game {
  final String path;
  final String title;
  final int price;
  final String description;
  final int qte;

  Game(
      {required this.path,
      required this.title,
      required this.price,
      this.description = "",
      this.qte = 10});

  // generate toString
  @override
  String toString() {
    return 'Game{path: $path, name: $title, price: $price, description: $description, qte: $qte}';
  }
}
