package com.web.app.service;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.dao.UserDAO;
import com.web.app.entity.Role;
import com.web.app.entity.User;

/*
 * Имплементация UserDetailsService из Spring Security
 * 
 */

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDAO.findByUsername(username);

		Set<GrantedAuthority> authorities = new HashSet<>();
		
		for (Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),  user.getPassword(), authorities);
	}

	
	
}
