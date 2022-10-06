'use strict';

import Game from '../models/game.js';
import RespObj from '../models/respObj.js';
import { GAMES } from '../utils/data.js';
import { NOT_FOUND_RESPONSE } from '../utils/responses.js';

export const findAll = () =>
	new RespObj({
		object: GAMES.map((g) => [{ id: g.id, title: g.title, price: g.price }]),
		status: 200,
	});

export const save = (/** @type {Game} */ game) => {
	game.id = GAMES[GAMES.length - 1].id + 1;
	GAMES.push(game);
	return new RespObj({ object: game, status: 201 });
};

export const findGameById = (/** @type {number} */ id) => {
	const game = GAMES.find((g) => g.id === id);
	return game == undefined
		? NOT_FOUND_RESPONSE('Game')
		: new RespObj({ object: game, status: 200 });
};

/**
 *
 * @param {number} id - The id of the game to modify
 * @param {Game} body - The new game details
 */
export const updateGame = (id, body) => {
	const game = GAMES.find((g) => g.id === id);
	if (game == undefined) return NOT_FOUND_RESPONSE('Game');
	else {
		const index = GAMES.indexOf(game);
		GAMES[index] = body;
		return new RespObj({
			object: GAMES[index],
			status: 200,
		});
	}
};
