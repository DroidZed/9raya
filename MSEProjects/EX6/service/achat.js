'use strict';

import Achat from '../models/achat.js';
import RespObj from '../models/respObj.js';
import { ACHATS } from '../utils/data.js';
import {
	BAD_REQUEST_RESPONSE,
	NOT_FOUND_RESPONSE,
} from '../utils/responses.js';
import { findGameById } from './game.js';
import { findUserById } from './user.js';

export const buyGame = (
	/** @type {number} */ gameId,
	/** @type {number} */ userId
) => {
	console.log('buyGame', gameId, userId);

	const userObj = findUserById(userId);

	const gameObj = findGameById(gameId);

	if (userObj.status == 404) return NOT_FOUND_RESPONSE('User');

	if (gameObj.status == 404) return NOT_FOUND_RESPONSE('Game');

	const user = userObj.object;
	const game = gameObj.object;

	if (user.wallet < game.price) return BAD_REQUEST_RESPONSE('Not enough money');

	if (game.quantity == 0) return BAD_REQUEST_RESPONSE('Game is out of stock');

	user.wallet -= game.price;

	game.quantity -= 1;

	user.games.push(game);

	const achat = new Achat(ACHATS[ACHATS.length - 1].id + 1, new Date());

	ACHATS.push(achat);

	return new RespObj({
		message: 'Game bought',
		status: 200,
		object: {
			user: user,
			game: game,
			achat: achat,
		},
	});
};
