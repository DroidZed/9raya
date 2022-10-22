'use strict'

import express from 'express'

import {
    listGames,
    publishGame,
    getGameDetails,
    modifyGame,
    purchaseGame,
} from '../controllers/game.js'

import { body } from 'express-validator'
import { gameImageConfig } from '../middlewares/multer-config.js'

const router = express.Router()

router.route('/').get(listGames)

router
    .route('/publish')
    .post(
        body('title').isLength({ min: 3, max: 100 }),
        body('price').isNumeric(),
        body('description').isLength({ min: 10 }),
        body('quantity').isNumeric(),
        gameImageConfig,
        publishGame
    )

router.route('/buy').post(purchaseGame)

router
    .route('/:gameId')
    .get(getGameDetails)
    .put(
        body('title').isLength({ min: 3, max: 100 }),
        body('price').isNumeric(),
        body('description').isLength({ min: 10 }),
        body('quantity').isNumeric(),
        gameImageConfig,
        modifyGame
    )

export default router
