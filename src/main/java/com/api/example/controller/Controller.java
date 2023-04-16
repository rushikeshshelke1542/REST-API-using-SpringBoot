package com.api.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.example.entites.Person;
import com.api.example.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/persons")
public class Controller {
   
	@Autowired
	private PersonService personservice;
	
	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody Person person){
		
		Person savePerson = personservice.createPerson(person);
		
		return new ResponseEntity<>(savePerson, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable int id){
		
		Person getPerson = personservice.getPersonById(id);
		
		return new ResponseEntity<>(getPerson, HttpStatus.OK);
		
	}
	
	
	
	
	@GetMapping
	public ResponseEntity<List<Person>> getAllPerson(){
		
		List<Person> getPerson = personservice.getAllPerson();
		
		return new ResponseEntity<>(getPerson, HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable int id , @RequestBody Person person){
		
		person.setId(id);
		
		Person updatedPerson = personservice.updatePerson(person);
		
		return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteperson(@PathVariable("id") int id){
		
		personservice.deletePerson(id);
		
		return new ResponseEntity<>("User deleted", HttpStatus.OK);
		
	}
	
	
	
	
}
