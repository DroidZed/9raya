import { Schema, model } from 'mongoose'

export default model(
    'Achat',
    new Schema(
        {
            boughtDate: { type: Date, required: true },
            game: {
                type: Schema.Types.ObjectId,
                ref: 'Game',
            },
            user: {
                type: Schema.Types.ObjectId,
                ref: 'User',
            },
        },
        {
            timestamps: true,
        }
    )
)
