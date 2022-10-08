import mongoose from 'mongoose'

const { Schema, model } = mongoose

const userSchema = new Schema(
    {
        username: { type: String, required: true },
        password: { type: String, required: true },
        wallet: { type: Number, required: true },
        games: [
            {
                type: Schema.Types.ObjectId,
                ref: 'Game',
            },
        ],
    },
    {
        timestamps: true,
    }
)

export default model('User', userSchema)
