package com.web.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.web.app.entity.People;

@Repository
public class PeopleDAOImpl implements PeopleDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
@Override
public List<People> getAllPeople() {
	
	Session session = sessionFactory.getCurrentSession();
	
	List<People> peoples = session.createQuery("FROM People", People.class).getResultList();
	
	return peoples;
}



@Override
public void savePeople(People people) {
	
	Session session = sessionFactory.getCurrentSession();
	
	session.saveOrUpdate(people);
	
}

@Override
public People getPeopleById(int id) {
	
	Session session = sessionFactory.getCurrentSession();
	
	People people = session.get(People.class, id);
	
	
	return people;
}


@Override
public void deletePeople(int id) {
	Session session = sessionFactory.getCurrentSession();
	session.delete(session.get(People.class, id));
	
}


}
