import * as dotenv from 'dotenv';
import express from 'express';
import { readFile } from 'fs';

dotenv.config();

class Game {
	Year = 0;
	GameLink = '';
	Game = '';
	Platform = '';
	PlatformLink = '';

	/**
	 * @param {number} Year
	 * @param {string} GameLink
	 * @param {string} Game
	 * @param {string} Platform
	 * @param {string} PlatformLink
	 */
	constructor(Year, GameLink, Game, Platform, PlatformLink) {
		this.Year = Year;
		this.GameLink = GameLink;
		this.Game = Game;
		this.Platform = Platform;
		this.PlatformLink = PlatformLink;
	}
}

/**
 * Reads the file and returns the content as an array of Game objects
 * @param callback a callback function to execute the code
 */
const getGames = async (callback) => {
	readFile('SteamGames.json', 'utf8', (err, data) => {
		if (err) {
			return callback(err);
		}
		callback(null, JSON.parse(data));
	});
};

const app = express();

const hostname = process.env.HOSTNAME || '127.0.0.1';

// @ts-ignore
const PORT = Number.parseInt(process.env.PORT) || 9090;

app.get('/', (req, res) => {
	res.json({ message: 'Hello World' });
});

app.get('/secret', (req, res) => {
	res.status(401).json({ message: 'Unauthorized' });
});

/*
app.get('/entity', (req, res) => {
	const game = new Game('Super Mario Bros', 1985);
	res.json(game);
} );
*/

app.get('/game', async (_, res) => {
	await getGames((err, games) => {
		err ? res.status(500).json({ message: err }) : res.json(games);
	});
});

app.get('/game/select/:year', async (req, res) => {
	await getGames((err, games) => {
		if (err) return res.status(500).json({ message: err });

		const gamesByYear = games.filter((game) => +req.params.year < game.Year);
		return gamesByYear.length !== 0
			? res.json(gamesByYear)
			: res.status(404).json({ message: 'Not Found' });
	});
});

app.get('/game/names', async (req, res) => {
	await getGames((err, games) => {
		err
			? res.status(500).json({ message: err })
			: res.json(games.map((game) => game.Game));
	});
});

app.get('/game/years', async (req, res) => {
	await getGames((err, games) => {
		err
			? res.status(500).json({ message: err })
			: res.json(games.map((game) => game.Year));
	});
});

app.get('/game/:name', async (req, res) => {
	await getGames((err, games) => {
		if (err) return res.status(500).json({ message: err });

		const game = games.find((game) => req.params.name == game.Game);
		game
			? res.json(game).status(200)
			: res.status(404).json({ message: 'Game not found' });
	});
});

app.listen(PORT, hostname, () => {
	console.log(`Server running at http://${hostname}:${PORT}/`);
});
