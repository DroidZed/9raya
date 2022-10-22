import express from 'express'
import { body } from 'express-validator'
import mongoose from 'mongoose'

import { login, register } from '../controllers/user.js'
import { userImageConfig } from '../middlewares/multer-config.js'

const router = express.Router()

router.route('/login').post(login)
router
    .route('/')
    .get((req, res) => res.status(200).json({ message: 'Hello World!' }))
router
    .route('/register')
    .post(
        body('username').isLength({ min: 3, max: 100 }),
        body('password').isLength({ min: 8 }),
        body('wallet').isNumeric(),
        userImageConfig,
        register
    )

router.route('/dropDB').get((req, res) => {
    mongoose.connection.db.dropDatabase((err, result) => {
        if (err) {
            res.status(500).json({ message: err.message })
        } else {
            res.status(200).json({ message: 'Database dropped' })
        }
    })
})

export default router
