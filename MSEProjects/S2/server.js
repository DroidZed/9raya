import * as dotenv from 'dotenv';
import express from 'express';
import { readFileSync } from 'fs';

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
 * @returns {Promise<Game[]>}
 */
const getGames = async () => {
	const games = readFileSync('SteamGames.json', 'utf8');
	return games ? JSON.parse(games) : null;
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

app.get('/game', async (_, res) => res.json(await getGames()));

app.get('/game/select/:year', async (req, res) => {
	const games = await getGames();
	const gamesByYear = games.filter((game) => +req.params.year < game.Year);
	return gamesByYear.length !== 0
		? res.json(gamesByYear)
		: res.status(404).json({ message: 'Not Found' });
});

app.get('/game/names', async (req, res) => {
	const games = await getGames();
	const gamesByName = games.map((game) => game.Game);
	res.json(gamesByName);
});

app.get('/game/years', async (req, res) => {
	const games = await getGames();
	const gamesYears = games.map((game) => game.Year);
	res.json(gamesYears);
});

app.get('/game/:name', async (req, res) => {
	const games = await getGames();
	const game = games.find((game) => req.params.name == game.Game);
	game
		? res.json(game).status(200)
		: res.status(404).json({ message: 'Game not found' });
});

app.listen(PORT, hostname, () => {
	console.log(`Server running at http://${hostname}:${PORT}/`);
});
