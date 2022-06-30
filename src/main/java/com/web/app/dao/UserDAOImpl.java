package com.web.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.app.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUsername(String userName) {

		Session session = sessionFactory.getCurrentSession();

		User user = (User) session.createQuery("from User where username = :username")
				.setParameter("username", userName).uniqueResult();

		return user;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();

		session.save(user);

	}

	@Override
	public User findByUsernameValidator(String userName) {
		Session session = sessionFactory.getCurrentSession();

		List<User> users = (List<User>) session.createQuery("from User where username = :username").setParameter("username", userName).list();
		
		if (users.size() == 0) {
			return null;
		}
		User user = users.get(0);

		return user;
	}

}
