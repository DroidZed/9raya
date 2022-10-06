import express from 'express';
import { login, register } from '../controllers/user.js';

const router = express.Router();

router.route('/login').post(login);
router
	.route('/')
	.get((req, res) => res.status(200).json({ message: 'Hello World!' }));
router.route('/register').post(register);

export default router;
