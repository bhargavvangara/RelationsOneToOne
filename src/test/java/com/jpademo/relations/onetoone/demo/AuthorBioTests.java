package com.jpademo.relations.onetoone.demo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpademo.relations.onetoone.demo.entity.Author;
import com.jpademo.relations.onetoone.demo.entity.Biography;
import com.jpademo.relations.onetoone.demo.repo.AuthorRepo;

@SpringBootTest
class AuthorBioTests {
	@Autowired
	AuthorRepo authorRepo;
	
	@Test
	void saveAuthorAndBio() {
		Author author = new Author();
		author.setName("John Doe");
		author.setNationality("American");
		Biography bio = new Biography();
		bio.setBio("John Doe is a famous author.");
		bio.setDob(LocalDate.of(1980, 1, 1));
		bio.setAuthor(author);
		author.setBiography(bio);
		authorRepo.save(author);
		
	}
	

}
