'use strict';

import { USERS } from '../utils/data.js';
import RespObj from '../models/respObj.js';
import User from '../models/user.js';
import { NOT_FOUND_RESPONSE } from '../utils/responses.js';

export const createUser = (/** @type {User} */ user) => {
	user.id = USERS[USERS.length - 1].id + 1;
	user.games = [];
	USERS.push(user);
	return new RespObj({ object: user, status: 201 });
};

export const findUserById = (/** @type {number} */ id) => {
	const user = USERS.find((u) => u.id === id);
	return user == undefined
		? NOT_FOUND_RESPONSE('User')
		: new RespObj({ object: user, status: 200 });
};

export const findUserByUsername = (/** @type {string} */ username) => {
	const user = USERS.find((u) => u.username === username);
	return user == undefined
		? NOT_FOUND_RESPONSE('User')
		: new RespObj({ object: user, status: 200 });
};

export const updateUser = (
	/** @type {number} */ id,
	/** @type {User} */ body
) => {
	const { object, status } = findUserById(id);
	if (status == 404) return NOT_FOUND_RESPONSE('User');
	else {
		const index = USERS.indexOf(object);
		USERS[index] = body;
		return new RespObj({
			object: USERS[index],
			status: 200,
		});
	}
};
