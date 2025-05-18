package com.jpademo.relations.onetoone.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.jpademo.relations.onetoone.demo.entity.Person;

public interface PersonRepo extends CrudRepository<Person, Integer> {

}
