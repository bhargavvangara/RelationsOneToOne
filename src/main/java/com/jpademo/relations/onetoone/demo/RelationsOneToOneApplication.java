package com.jpademo.relations.onetoone.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RelationsOneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationsOneToOneApplication.class, args);
	}

}
