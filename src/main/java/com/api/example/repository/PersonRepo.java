package com.api.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.example.entites.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

	
}
