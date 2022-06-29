package com.web.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.app.entity.User;



@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findByUsername(String userName) {
		
		Session session = sessionFactory.getCurrentSession();
		
		User user =  (User) session.createQuery("from User where username = :username").setParameter("username", userName).list().get(0);
		
		System.out.println("UserDAOImpl - findByUsername : " + user);
		
		
		return user;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(user);
		
	}

}
