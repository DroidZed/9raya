class Game {
  final String path;
  final String title;
  final int price;
  final String description;
  final int qte;

  Game(this.path, this.title, this.price, this.description, this.qte);

  // generate toString
  @override
  String toString() {
    return 'Game{path: $path, name: $title, price: $price, description: $description, qte: $qte}';
  }
}
