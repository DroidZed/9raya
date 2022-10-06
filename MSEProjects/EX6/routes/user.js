'use strict';

import express from 'express';
import { modifyProfile } from '../controllers/user.js';

const router = express.Router();

router.route('/:userId').put(modifyProfile);

export default router;
