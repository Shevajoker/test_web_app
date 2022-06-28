package com.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.app.entity.User;

public interface UserDAO {

	public User findByUsername(String userName);
	public void save (User user);
	
}
