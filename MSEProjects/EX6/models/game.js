import { Schema, model } from 'mongoose'

export default model(
    'Game',
    new Schema(
        {
            title: { type: String, required: true },
            price: { type: Number, required: true },
            description: { type: String, required: true },
            image: { type: String, required: true },
            quantity: { type: Number, required: true },
        },
        {
            timestamps: true,
        }
    )
)
