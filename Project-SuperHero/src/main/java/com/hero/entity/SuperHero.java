package com.hero.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class SuperHero {

	@Id
	private Long id;
	private String userName;
	private String name;
	private String Gender;
	private String emailId; 
	private String movies;
	private Long mobileNo;
	private String address;
	private String pinCode;
	
}
