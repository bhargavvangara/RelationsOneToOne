package com.jpademo.relations.onetoone.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	@Column(name="valid_from")
	private LocalDate issueDate;
	@Column(name="valid_to")
	private LocalDate expiryDate;
	@Column(name="createddt", nullable = false, updatable = false)
	@CreatedDate
	private LocalDate creationDate;
	@Column(name="updateddt", nullable = false)
	@LastModifiedDate
	private LocalDate lastUpdatedDate;
	@OneToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	
	public void addPerson(Person person) {
		this.person = person;
		if (person != null) {
			person.setLicense(this);
		}
	}
}
