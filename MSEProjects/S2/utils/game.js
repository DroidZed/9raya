import { readFileSync } from 'fs';

const getGames = async () => {
	const games = readFileSync('SteamGames.json', 'utf8');
	return JSON.parse(games);
};

export default getGames;
