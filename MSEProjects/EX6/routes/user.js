'use strict'

import express from 'express'
import { body } from 'express-validator'
import { modifyProfile } from '../controllers/user.js'
import { userImageConfig } from '../middlewares/multer-config.js'

const router = express.Router()

router
    .route('/:userId')
    .put(
        body('username').isLength({ min: 3, max: 100 }),
        body('password').isLength({ min: 8 }),
        body('wallet').isNumeric(),
        userImageConfig,
        modifyProfile
    )

export default router
