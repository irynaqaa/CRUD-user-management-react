const { Router } = require('express');
const router = Router();
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const User = require('../Models/User');

router.post('/login', async (req, res) => {
    try {
        const { email, password } = req.body;
        if (!email || !password) {
            return res.status(400).send({ message: 'Email and password are required' });
        }
        const user = await User.findOne({ email });
        if (!user) {
            return res.status(401).send({ message: 'Invalid email or password' });
        }
        const isValidPassword = await bcrypt.compare(password, user.password);
        if (!isValidPassword) {
            return res.status(401).send({ message: 'Invalid email or password' });
        }
        const token = jwt.sign({ userId: user._id }, process.env.SECRET_KEY, { expiresIn: '1h' });
        return res.send({ token, message: 'Logged in successfully' });
    } catch (error) {
        console.error(error);
        return res.status(500).send({ message: 'Internal Server Error' });
    }
});

router.post('/register', async (req, res) => {
    try {
        const { email, password, name } = req.body;
        if (!email || !password || !name) {
            return res.status(400).send({ message: 'Email, password and name are required' });
        }
        const existingUser = await User.findOne({ email });
        if (existingUser) {
            return res.status(409).send({ message: 'Email already exists' });
        }
        const hashedPassword = await bcrypt.hash(password, 10);
        const user = new User({ email, password: hashedPassword, name });
        await user.save();
        return res.send({ message: 'Registered successfully' });
    } catch (error) {
        console.error(error);
        return res.status(500).send({ message: 'Internal Server Error' });
    }
});

module.exports = router;