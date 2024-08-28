const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');

mongoose.model('User', {
  name: String,
  email: String
});

const User = mongoose.model('User');

router.get('/users', async (req, res) => {
  try {
    const users = await User.find().exec();
    res.json(users);
  } catch (err) {
    console.error(err);
    res.status(500).json({ message: 'Failed to retrieve users' });
  }
});

module.exports = router;