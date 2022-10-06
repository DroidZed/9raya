'use strict';

import { createUser, findUserByUsername, updateUser } from '../service/user.js';

// ! /login
export const login = (req, res) => {
	const { username, password } = req.body;

	const result = findUserByUsername(username);

	if (result.status == 404) res.status(404).json({ message: result.message });
	else {
		const user = result.object;

		if (user.password == password)
			res.status(200).json({ message: 'Logged in', entity: user });
		else res.status(400).json({ message: 'Bad credentials' });
	}
};

// ! /register
export const register = (req, res) => {
	const userInfos = req.body;

	const result = findUserByUsername(userInfos.username);

	if (result.status == 200)
		res.status(400).json({ message: 'Username already taken' });
	else {
		const creationResult = createUser(userInfos);
		res
			.status(creationResult.status)
			.json({ message: 'User created', entity: creationResult.object });
	}
};

// ! /:userId
export const modifyProfile = (req, res) => {
	const result = updateUser(Number.parseInt(req.params.userId), req.body);

	if (result.status == 404) res.status(404).json({ message: result.message });
	else res.status(200).json({ message: 'User updated', entity: result.object });
};
