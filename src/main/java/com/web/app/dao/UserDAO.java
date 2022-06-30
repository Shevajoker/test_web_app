package com.web.app.dao;


import com.web.app.entity.User;

public interface UserDAO {

	public User findByUsername(String userName);
	public User findByUsernameValidator(String userName);
	public void save (User user);
	
}
