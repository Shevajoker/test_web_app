package com.web.app.service;

import java.util.List;

import com.web.app.entity.People;

public interface PeopleService {
	
	public List<People> getAllPeople();
	public void savePeople (People people);
	public People getPeopleById(int id);
	public void deletePeople(int id);
}
