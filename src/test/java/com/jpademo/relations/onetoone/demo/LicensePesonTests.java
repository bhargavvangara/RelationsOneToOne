package com.jpademo.relations.onetoone.demo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jpademo.relations.onetoone.demo.entity.License;
import com.jpademo.relations.onetoone.demo.entity.Person;
import com.jpademo.relations.onetoone.demo.repo.LicenseRepo;
import com.jpademo.relations.onetoone.demo.repo.PersonRepo;

@SpringBootTest
class LicensePesonTests {
	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	LicenseRepo licenseRepo;

	@Test
	void savePersonWithLicense() {
		Person person = new Person();
		person.setFname("John");
		person.setLname("Doe");
		person.setAge(30);
		
		License license = new License();
		license.setType("Driver's License");
		license.setIssueDate(LocalDate.now());
		license.setExpiryDate(LocalDate.now().plusYears(5));
		license.addPerson(person);
		personRepo.save(person);
	}
	
	@Test
	@Transactional
	@Rollback(value = false)
	void savePersonWithLicenseFromLicenseRepo() {
		Person person = new Person();
		person.setFname("Jenny");
		person.setLname("Doe");
		person.setAge(26);
		System.out.println("checking id before:"+person.getId());
		personRepo.save(person); // Here the person is saved but not catching the 
		// returned person object. so, still the original person object is in transient state.
		// Means person may have id but changes made are not tracked by hibernate.
		// so, we need to save the person object again if any changes are 
		// required in person. if we catch the returned person object then 
		// the changes made to the person object will be tracked by hibernate.
		// No need to save the person object again.
		System.out.println("checking id after:"+person.getId());
		License license = new License();
		license.setType("Travel License");
		license.setIssueDate(LocalDate.now());
		license.setExpiryDate(LocalDate.now().plusYears(10));
		license.setPerson(person);
		licenseRepo.save(license);
		
	}

}
