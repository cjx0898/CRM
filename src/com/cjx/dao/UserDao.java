package com.cjx.dao;

import com.cjx.bean.User;

public interface UserDao {

	User login(User user, String state);

	User registerName(String user_code);

}
