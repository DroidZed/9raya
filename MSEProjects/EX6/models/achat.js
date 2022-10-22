import { Schema, model } from 'mongoose'

const achatSchema = new Schema(
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

export default model('Achat', achatSchema)
