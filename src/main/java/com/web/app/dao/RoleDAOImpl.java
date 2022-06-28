package com.web.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.app.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public Role getFirstRole(Long id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return (Role) session.createQuery("from Role where id = :id").setParameter("id", id).uniqueResult();
	}

}
