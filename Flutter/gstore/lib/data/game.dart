class Game {
  final String? _id;
  final String imagePath;
  final String title;
  final int price;
  final String description;
  final int qte;

  Game(this._id, this.imagePath, this.title, this.price, this.description,
      this.qte);

  // generate toString
  @override
  String toString() {
    return 'Game{path: $imagePath, name: $title, price: $price, description: $description, qte: $qte}';
  }
}
