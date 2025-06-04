package com.cdac.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Students")
public class Student {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long roll;
	@Column(name="Sname",length = 20)
	private String name;
	
	@Column(name="fname",length = 20)
	private String fName;
	private int marks;
}
