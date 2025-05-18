package com.jpademo.relations.onetoone.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.jpademo.relations.onetoone.demo.entity.License;

public interface LicenseRepo extends CrudRepository<License, Integer> {

}
