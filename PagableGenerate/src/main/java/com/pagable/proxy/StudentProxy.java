package com.pagable.proxy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(Include.NON_EMPTY)
public class StudentProxy {

	private Long sid;
	private String fname;
	private String lname;
	private String mobile;
	private String dob;
	private String email;
	private String address;
	private Integer pincode;
}
