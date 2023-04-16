package com.api.example.service;

import java.util.List;

import com.api.example.entites.Person;

public interface PersonService {
	
	Person createPerson(Person person);
	
	List<Person> getAllPerson();
	
	Person getPersonById(int id);
	
	Person updatePerson(Person person);
	
	void deletePerson(int id);
	


}
