package com.cjx.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cjx.bean.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User login(User user, String state) {
		
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ? and user_password = ? and user_state = ?", user.getUser_code(),user.getUser_password(),state);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		
		
		return null;
	}

	@Override
	public User registerName(String user_code) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?",user_code);
		if(list != null && list.size() >0){
			return list.get(0);
		}
		return null;
	}

}
