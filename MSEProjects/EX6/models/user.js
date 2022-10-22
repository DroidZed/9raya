import { Schema, model } from 'mongoose'

export default model(
    'User',
    new Schema(
        {
            username: { type: String, required: true },
            password: { type: String, required: true },
            wallet: { type: Number, required: true },
        },
        {
            timestamps: true,
        }
    )
)
