package com.cdac.entities;

import java.time.LocalDate;
//import annotations from JPA
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="new_user") //to specify table name
//lombok annotations - class level annotations
@NoArgsConstructor //def ctor
@Getter //all getters
@Setter //all setters
@ToString(exclude = {"password","image"}) //toString
public class User {
	//Reco - use ref type for easier null checking for hibernate
	@Id //mandatory => PK constraint
	//for automatic generation of ids -using auto_increment (MySQL)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;//Integer
	@Column(length = 20,name="first_name") //col name , varchar size
	private String firstName;
	@Column(length = 30,name="last_name") //col name , varchar size
	private String lastName;
	@Column(length = 30,unique = true)//varchar(30), unique constraint
	private String email;
	@Column(length = 20,nullable = false)//not null
	private String password;
//	@Transient //skips from persistence - no col generation
//	private String confirmPassword;
	private LocalDate dob;
	@Enumerated(EnumType.STRING)//col type - varchar : name of constant
	@Column(length = 30,name="user_role")
	private UserRole userRole;
	@Lob //col type for mysql - longblob
	private byte[] image;
	@Column(name="subscription_amount")
	private double subscriptionAmount;
	
	//parameterized ctor for sign up
	public User(String firstName, String lastName, String email, String password,
			LocalDate dob, UserRole userRole,double subscriptionAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.userRole = userRole;
		this.subscriptionAmount=subscriptionAmount;
	}
	//adding overloaded parameterized ctor - for JPQL constr expression
	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}	
}
