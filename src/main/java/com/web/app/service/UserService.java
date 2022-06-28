package com.web.app.service;

import com.web.app.entity.User;

public interface UserService {

	public void save(User user);
	public User findByUsername(String usernsme);
	
}
