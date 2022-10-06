'use strict';

import Achat from '../models/achat.js';
import Game from '../models/game.js';
import User from '../models/user.js';

export const GAMES = [
	new Game({
		id: 1,
		title: 'The Witcher 3: Wild Hunt',
		price: 39.99,
		description:
			'The Witcher 3: Wild Hunt is a 2015 action role-playing game developed and published by CD Projekt. Based on The Witcher series of fantasy novels by Polish author Andrzej Sapkowski, it is the sequel to the 2011 game The Witcher 2: Assassins of Kings and the third main installment in The Witcher video game series, played in an open world with a third-person perspective.',
		quantity: 40,
	}),
	new Game({
		id: 2,
		title: 'Cyberpunk 2077',
		price: 59.99,
		description:
			'Cyberpunk 2077 is an upcoming action role-playing video game developed and published by CD Projekt. Based on the Cyberpunk 2020 pen-and-paper role-playing game, it is set in Night City, an open world with six distinct regions. The game is played from a first-person or third-person perspective and its story follows V, a mercenary outlaw going after a one-of-a-kind implant that is the key to immortality.',
		quantity: 80,
	}),
	new Game({
		id: 3,
		title: 'The Elder Scrolls V: Skyrim - Special Edition',
		price: 39.99,
		description:
			"The Elder Scrolls V: Skyrim Special Edition is a remastered version of the 2011 game The Elder Scrolls V: Skyrim, the fifth installment in The Elder Scrolls series. The Special Edition includes mod support and enhancements to the game's visuals, audio, and controls.",
		quantity: 20,
	}),
	new Game({
		id: 4,
		title: 'Fallout 4',
		price: 19.99,
		description:
			'Fallout 4 is an action role-playing video game developed by Bethesda Game Studios and published by Bethesda Softworks. It is the fifth major installment in the Fallout series and was released worldwide on November 10, 2015, for Microsoft Windows, PlayStation 4 and Xbox One. Fallout 4 is the first game in the series to feature a first-person perspective.',
		quantity: 15,
	}),
];

export const USERS = [
	new User({
		id: 1,
		username: 'Admin',
		password: 'admin',
		wallet: 1000,
		games: [],
	}),
];

export const ACHATS = [new Achat(1, new Date())];
