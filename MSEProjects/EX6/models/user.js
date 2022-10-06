'use strict';

export default class User {
	constructor({
		id = 0,
		username = '',
		password = '',
		wallet = 0.0,
		games = [],
	}) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.wallet = wallet;
		this.games = games;
	}
}
