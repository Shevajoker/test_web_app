package com.web.app.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.app.dao.RoleDAO;
import com.web.app.dao.UserDAO;
import com.web.app.entity.Role;
import com.web.app.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcryptRasswordEncoder; 
	
	
	
	@Override
	@Transactional
	public void save(User user) {
		
		user.setPassword(bcryptRasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleDAO.getFirstRole(1L));
		user.setRoles(roles);
		userDAO.save(user);
		
	}
	
	@Override
	@Transactional
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	@Transactional
	public User findByUsernameValidator(String userName) {
		return userDAO.findByUsernameValidator(userName);
	}
}
