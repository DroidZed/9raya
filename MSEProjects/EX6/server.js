'use strict'

import mongoose from 'mongoose'
import express from 'express'
import dotenv from 'dotenv'

import gamesRouter from './routes/game.js'
import userRouter from './routes/user.js'
import mainRouter from './routes/main.js'
import { errorHandler, notFoundError } from './middlewares/error-handler.js'
import morgan from 'morgan'
import cors from 'cors'

dotenv.config()

const HOSTNAME = 'localhost'
const PORT = process.env.PORT || 3000
const DBNAME = process.env.DBNAME

mongoose.set('debug', true)
mongoose.Promise = global.Promise
mongoose
    // @ts-ignore
    .connect(process.env.MONGO_URI)
    .then(() => {
        console.log(`Connected to ${DBNAME}`)
    })
    .catch((err) => {
        console.error(err)
    })

const app = express()

app.use(cors())
app.use(morgan('dev'))
app.use(express.json())
app.use(express.urlencoded({ extended: true }))
app.use(
    '/img',
    express.static('public/images', {
        extensions: ['jpg', 'jpeg', 'png', 'gif', 'svg'],
    })
)

app.use('/', mainRouter)
app.use('/games', gamesRouter)
app.use('/user', userRouter)

app.use(notFoundError)
app.use(errorHandler)

// @ts-ignore
app.listen(PORT, HOSTNAME, () => {
    console.log(`Server running at http://${HOSTNAME}:${PORT}/`)
})
