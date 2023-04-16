package com.api.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.example.entites.Person;
import com.api.example.repository.PersonRepo;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service
public class ServiceImplement implements PersonService {

	@Autowired
	private PersonRepo personrepo;
	
	@Override
	public Person createPerson(Person person) {
		// TODO Auto-generated method stub
		
		return personrepo.save(person);
	}

	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		
		return personrepo.findAll();
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		
	Optional<Person> person = personrepo.findById(id);
		
		return person.get();
	}

	@Override
	public Person updatePerson(Person person) {
		// TODO Auto-generated method stub
		
		Person exsitingPerson = personrepo.findById(person.getId()).get();
		
		exsitingPerson.setName(person.getName());
		exsitingPerson.setCity(person.getCity());
		exsitingPerson.setGender(person.getGender());
		
		
		return personrepo.save(exsitingPerson);
	}

	@Override
	public void deletePerson(int id) {
		
		personrepo.deleteById(id);
		
		// TODO Auto-generated method stub
		
	}

}
