package com.web.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.app.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getAllEmployees() {
	Session session = sessionFactory.getCurrentSession();
	
	List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
	
		return employees;
	}
	
}
