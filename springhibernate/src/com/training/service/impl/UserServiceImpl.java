package com.training.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.dao.UserDao;
import com.training.service.UserService;

public class UserServiceImpl implements UserService
{
		@Autowired
		private UserDao userDao;

		public UserDao getUserDao()
		{
				return this.userDao;
		}

		public void setUserDao(UserDao userDao)
		{
				this.userDao = userDao;
		}

		

		@Override
		public boolean isValidUser(String username, String password) throws SQLException
		{
				return userDao.isValidUser(username, password);
		}

}
