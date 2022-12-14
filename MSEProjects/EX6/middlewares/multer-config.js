'use strict'

import multer, { diskStorage } from 'multer'

import { join, dirname } from 'path'
import { fileURLToPath } from 'url'

const MIME_TYPES = {
    'image/jpg': 'jpg',
    'image/jpeg': 'jpg',
    'image/png': 'png',
    'image/gif': 'gif',
}

export default function (req, file, path, fileSizeLimit) {
    return multer({
        storage: diskStorage({
            destination: (req, file, callback) => {
                const _dirname = dirname(fileURLToPath(import.meta.url))
                callback(null, join(_dirname, `../public/images/${path}`))
            },
            filename: (req, file, callback) => {
                const name = file.originalname.split(' ').join('_')
                const extension = MIME_TYPES[file.mimetype]
                callback(null, name + Date.now() + '.' + extension)
            },
        }),
        limits: {
            fileSize: fileSizeLimit,
        },
    }).single('image')
}
