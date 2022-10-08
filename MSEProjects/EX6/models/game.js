import mongoose from 'mongoose'

const { Schema, model } = mongoose

const gameSchema = new Schema(
    {
        title: { type: String, required: true },
        price: { type: Number, required: true },
        description: { type: String, required: true },
        quantity: { type: Number, required: true },
        players: [
            {
                type: Schema.Types.ObjectId,
                ref: 'User',
            },
        ],
    },
    {
        timestamps: true,
    }
)

export default model('Game', gameSchema)
