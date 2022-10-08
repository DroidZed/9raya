'use strict'

import mongoose from 'mongoose'
import express from 'express'
import dotenv from 'dotenv'

import gamesRouter from './routes/game.js'
import userRouter from './routes/user.js'
import mainRouter from './routes/main.js'

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

app.use(express.json())

app.use('/', mainRouter)
app.use('/games', gamesRouter)
app.use('/user', userRouter)

// @ts-ignore
app.listen(PORT, HOSTNAME, () => {
    console.log(`Server running at http://${HOSTNAME}:${PORT}/`)
})
