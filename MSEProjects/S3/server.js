import express from 'express';
import mongoose from 'mongoose';
import dotenv from 'dotenv';

import gameRoutes from './routes/game.js';

dotenv.config();

const HOSTNAME = 'localhost';
const PORT = process.env.PORT || 3000;
const DBNAME = process.env.DBNAME;

mongoose.set('debug', true);
mongoose.Promise = global.Promise;
mongoose
	// @ts-ignore
	.connect(process.env.MONGO_URI)
	.then(() => {
		console.log(`Connected to ${DBNAME}`);
	})
	.catch((err) => {
		console.error(`Error connecting to ${DBNAME}`);
	});

const app = express();

app.use(express.json());

app.use('/game', gameRoutes);

// @ts-ignore
app.listen(PORT, HOSTNAME, () => {
	console.log(`Server running at http://${HOSTNAME}:${PORT}/`);
});
