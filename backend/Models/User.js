const { Sequelize, DataTypes } = require('sequelize');

class User extends Sequelize.Model {}

User.init({
  id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true
  },
  name: {
    type: DataTypes.STRING
  },
  email: {
    type: DataTypes.STRING,
    unique: true
  },
  password: {
    type: DataTypes.STRING
  }
}, { sequelize, modelName: 'User' });