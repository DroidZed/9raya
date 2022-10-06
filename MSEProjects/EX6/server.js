'use strict';

import express from 'express';

import gamesRouter from './routes/game.js';
import userRouter from './routes/user.js';
import mainRouter from './routes/main.js';

const HOSTNAME = 'localhost';
const PORT = 3000;

const app = express();

app.use(express.json());

app.use('/', mainRouter);
app.use('/games', gamesRouter);
app.use('/user', userRouter);

app.listen(PORT, HOSTNAME, () => {
	console.log(`Server running at http://${HOSTNAME}:${PORT}/`);
});
