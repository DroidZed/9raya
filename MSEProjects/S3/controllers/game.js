import Game from '../schemas/game.js';

export function getAll(req, res) {
	Game.find({})
		.then((games) => {
			res.status(200).json(games);
		})
		.catch((err) => {
			res.status(500).json(err);
		});
}

export function addOne(req, res) {
	Game.create({
		name: req.body.name,
		year: req.body.year,
		onSale: req.body.onSale,
	})
		.then((newGame) => {
			res.status(201).json(newGame);
		})
		.catch((err) => {
			res.status(400).json(err);
		});
}

export function getOne(req, res) {
	Game.findOne({ name: req.params.name })
		.then((games) => {
			res.status(200).json(games);
		})
		.catch((err) => {
			res.status(500).json(err);
		});
}

export function putAll(req, res) {
	Game.updateMany({ onSale: true })
		.then((games) => {
			res.status(200).json(games);
		})
		.catch((err) => {
			res.status(500).json(err);
		});
}

export function patchOne(req, res) {
	Game.findOneAndUpdate(
		{ name: req.params.name },
		{ name: req.body.name, year: req.body.year, onSale: req.body.onSale }
	)
		.then((games) => {
			res.status(200).json(games);
		})
		.catch((err) => {
			res.status(500).json(err);
		});
}

export function deleteOne(req, res) {
	Game.findOneAndRemove({ name: req.params.name })
		.then((games) => {
			res.status(200).json(games);
		})
		.catch((err) => {
			res.status(500).json(err);
		});
}
