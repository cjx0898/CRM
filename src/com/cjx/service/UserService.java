package com.cjx.service;

import com.cjx.bean.User;

public interface UserService {

	User login(User user);

	User registerName(String user_code);

}
