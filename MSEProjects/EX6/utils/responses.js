'use strict';

import RespObj from '../models/respObj.js';

export const NOT_FOUND_RESPONSE = (/** @type {string} */ o) =>
	new RespObj({
		message: `${o} not found`,
		status: 404,
		object: null,
	});

export const BAD_REQUEST_RESPONSE = (/** @type {string} */ message) =>
	new RespObj({
		message: message,
		status: 400,
		object: null,
	});
