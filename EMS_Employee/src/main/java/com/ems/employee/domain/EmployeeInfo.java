package com.ems.employee.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(Include.NON_EMPTY)
@Entity
public class EmployeeInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String empid;
	private String name;
	private int dob;
	private String mobileno;

	// @Enumerated(EnumType.STRING)
	private String gender;
	private String address;
}

//{
//	"empid":"001",
//	"name":"raju",
//	"dob":"2000",
//	"gender":"MALE",
//	"address":"ahd"
//}