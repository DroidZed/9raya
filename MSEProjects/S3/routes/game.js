import express from 'express';
import {
	addOne,
	deleteOne,
	getAll,
	getOne,
	patchOne,
} from '../controllers/game.js';

const router = express.Router();

router.route('/').get(getAll).post(addOne);

router.route('/:name').get(getOne).patch(patchOne).delete(deleteOne);

export default router;
