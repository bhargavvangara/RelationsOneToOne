package com.jpademo.relations.onetoone.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.jpademo.relations.onetoone.demo.entity.Author;

public interface AuthorRepo extends CrudRepository<Author, Integer> {

}
