package com.cjx.service;

import org.springframework.transaction.annotation.Transactional;

import com.cjx.bean.User;
import com.cjx.dao.UserDao;
import com.cjx.util.State;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(User user) {
		return userDao.login(user,State.getState());
	}

	@Override
	public User registerName(String user_code) {
		return userDao.registerName(user_code);
	}
	
}
