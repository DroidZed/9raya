import express from 'express';
import { readFileSync } from 'fs';

const app = express();

class Game {
	constructor(name, year) {
		this.name = name;
		this.year = year;
	}
}

const getGames = async () => {
	const games = readFileSync('SteamGames.json', 'utf8');
	return JSON.parse(games);
};

const hostname = '127.0.0.1';

// @ts-ignore
const port = process.env.PORT | 9090;

app.get('/', (req, res) => {
	res.json({ message: 'Hello World' });
});

app.get('/secret', (req, res) => {
	res.status(401).json({ message: 'Unauthorized' });
});

app.get('/entity', (req, res) => {
	const game = new Game('Super Mario Bros', 1985);
	res.json(game);
});

app.get('/game', async (req, res) => {
	const games = await getGames();
	res.json(games);
});

app.get('/game/select/:year', async (req, res) => {
	const games = await getGames();
	const gamesByYear = games.filter((game) => +req.params.year <= game.Year);
	gamesByYear.length !== 0
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

app.listen(port, hostname, () => {
	console.log(`Server running at http://${hostname}:${port}/`);
});
