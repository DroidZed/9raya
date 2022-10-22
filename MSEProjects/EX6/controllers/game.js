'use strict'

import Game from '../models/game.js'
import Achat from '../models/achat.js'
import User from '../models/user.js'
import { validationResult } from 'express-validator'

// ! /
export async function listGames(_, res) {
    const games = await Game.find()

    if (games) res.status(200).json(games)
    else res.status(404).json({ message: 'No games found' })
}

// ! /publish
export async function publishGame(req, res) {
    if (validationResult(req.body).isEmpty()) {
        return res.status(400).json({ message: 'Invalid game data' })
    }

    const game = new Game({
        title: req.body.title,
        description: req.body.description,
        price: req.body.price,
        quantity: req.body.quantity,
        image: `${req.protocol}://${req.get('host')}/images/${
            req.file.filename
        }`,
    })

    try {
        const newGame = await game.save()
        res.status(201).json(newGame)
    } catch (err) {
        res.status(400).json({ message: err.message })
    }
}

// ! /buy
export async function purchaseGame(req, res) {
    const { gameId, userId } = req.body

    const game = await Game.findById(gameId)

    if (game) {
        const user = await User.findById(userId)

        if (user)
            if (user.wallet >= game.price) {
                const newWallet = user.wallet - game.price
                const newUser = await User.updateOne(
                    { _id: userId },
                    {
                        wallet: newWallet,
                    },
                    { new: true }
                )
                // add the user to the games document and decrement the quantity of the game but don't make it reach 0
                const newGame = await Game.updateOne(
                    { _id: gameId },
                    {
                        quantity: game.quantity >= 1 ? game.quantity - 1 : 0,
                    },
                    { new: true }
                )
                const achat = await Achat.create({
                    game: gameId,
                    user: userId,
                    boughtDate: new Date(),
                })
                res.status(201).json({ achat, newUser, newGame })
            } else res.status(400).json({ message: 'Not enough money' })
        else res.status(404).json({ message: 'User not found' })
    } else res.status(404).json({ message: 'Game not found' })
}

// ! /:gameId
export async function getGameDetails(req, res) {
    const game = await Game.findById(req.params.gameId)

    if (game) res.status(200).json(game)
    else res.status(404).json({ message: 'Game not found' })
}

// ! /:gameId
export async function modifyGame(req, res) {
    if (validationResult(req.body).isEmpty()) {
        return res.status(400).json({ message: 'Invalid game details' })
    }

    const game = await Game.findByIdAndUpdate(req.params.gameId, req.body, {
        new: true,
    })

    if (game) res.status(200).json(game)
    else res.status(404).json({ message: 'Game not found' })
}
