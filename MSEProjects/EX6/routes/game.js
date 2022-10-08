'use strict'

import express from 'express'

import {
    listGames,
    publishGame,
    getGameDetails,
    modifyGame,
    purchaseGame,
} from '../controllers/game.js'

const router = express.Router()

router.route('/').get(listGames)

router.route('/publish').post(publishGame)

router.route('/buy').post(purchaseGame)

router.route('/:gameId').get(getGameDetails).put(modifyGame)

export default router
