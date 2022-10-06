'use strict';

export default class Game {
	constructor({ id, title, price, description, quantity }) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}
}
