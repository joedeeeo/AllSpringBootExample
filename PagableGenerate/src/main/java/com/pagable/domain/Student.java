package com.pagable.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	private String fname;
	private String lname;
	private String mobile;
	private String dob;
	private String email;
	private String address;
	private Integer pincode;
	
	public Student(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
		}
	
}
