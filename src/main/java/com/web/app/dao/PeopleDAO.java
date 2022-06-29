package com.web.app.dao;

import java.util.List;

import com.web.app.entity.People;

public interface PeopleDAO {
	
	public List<People> getAllPeople();
	public void savePeople (People people);
	public People getPeopleById(int id);
	public void deletePeople(int id);
}
