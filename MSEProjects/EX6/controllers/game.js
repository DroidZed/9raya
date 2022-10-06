'use strict';

import { buyGame } from '../service/achat.js';
import { findAll, findGameById, save, updateGame } from '../service/game.js';

// ! /
export function listGames(_, res) {
	const result = findAll();

	res.status(result.status).json(result.object);
}
// ! /
export function publishGame(req, res) {
	const result = save(req.body);
	res
		.status(result.status)
		.json({ message: result.message, entity: result.object });
}

// ! /buy?gameId=1&userId=1
export function purchaseGame(req, res) {
	// print the query parameters to the console
	console.log(req.query);
	const result = buyGame(
		Number.parseInt(req.query.gameId),
		Number.parseInt(req.query.userId)
	);

	res
		.status(result.status)
		.json({ message: result.message, entity: result.object });
}

// ! /:gameId
export function getGameDetails(req, res) {
	const result = findGameById(Number.parseInt(req.params.gameId));

	res.status(result.status).json(result.object);
}

// ! /:gameId
export function modifyGame(req, res) {
	const result = updateGame(
		Number.parseInt(req.params.gameId),
		req.params.body
	);

	res
		.status(result.status)
		.json({ message: result.message, entity: result.object });
}
