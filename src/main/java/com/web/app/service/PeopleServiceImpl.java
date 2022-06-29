package com.web.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.app.dao.PeopleDAO;
import com.web.app.entity.People;

@Service
public class PeopleServiceImpl implements PeopleService {
	@Autowired
	private PeopleDAO peopleDAO;
	
@Override
@Transactional
public List<People> getAllPeople() {
	
	return peopleDAO.getAllPeople();
}


@Override
@Transactional
public void savePeople(People people) {
	peopleDAO.savePeople(people);
	
}

@Override
@Transactional
public People getPeopleById(int id) {

	return peopleDAO.getPeopleById(id);
}

@Override
@Transactional
public void deletePeople(int id) {
	peopleDAO.deletePeople(id);
	
}


}
