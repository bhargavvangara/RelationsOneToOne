package com.jpademo.relations.onetoone.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Biography {
	@Id
	private int id;
	private String bio;
	@Column(name = "birth_date")
	private LocalDate dob;
	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Author author;
}
