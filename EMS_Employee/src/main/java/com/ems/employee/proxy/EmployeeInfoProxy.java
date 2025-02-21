package com.ems.employee.proxy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(Include.NON_EMPTY)
public class EmployeeInfoProxy {

	private Long id;
	private String empid;
	private String name;
	private int dob;
	private String gender;
	private String address;
	private EmployeeProfileImageProxy profileImageProxy;
}
