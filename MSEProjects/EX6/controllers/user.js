'use strict'
import { validationResult } from 'express-validator'
import User from '../models/user.js'

// ! /login
export async function login(req, res) {
    const { username, password } = req.body

    const user = await User.findOne({ username: username, password: password })

    if (user) res.status(200).json(user)
    else res.status(404).json({ message: 'User not found' })
}

// ! /register
export async function register(req, res) {
    if (validationResult(req.body).isEmpty()) {
        return res.status(400).json({ message: 'Invalid user data' })
    }

    const { username, password, wallet } = req.body

    const user = await User.findOne({ username: username, password: password })

    if (user) res.status(400).json({ message: 'User already exists' })
    else {
        const newUser = await User.create({
            username: username,
            password: password,
            wallet: wallet,
            avatar: `${req.protocol}://${req.get('host')}/images/users/${
                req.file.filename
            }`,
        })
        res.status(201).json(newUser)
    }
}

// ! /:userId
export async function modifyProfile(req, res) {
    if (validationResult(req.body).isEmpty()) {
        return res.status(400).json({ message: 'Invalid user details' })
    }

    const { userId } = req.params

    const user = await User.findById(userId)

    if (user) {
        const { username, password, wallet } = req.body
        const newUser = await User.updateOne(
            { _id: userId },
            { username: username, password: password, wallet: wallet },
            { new: true }
        )
        res.status(200).json(newUser)
    } else res.status(404).json({ message: 'User not found' })
}
