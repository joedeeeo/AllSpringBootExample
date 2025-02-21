package com.sms.student.proxy;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sms.student.creationenum.Gender;
import com.sms.student.domain.Location;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class StudentProxy {

	private Long sid;
	
	@NotBlank(message = "name is mandatory")
	private String name;
	
	@NotNull(message = "mandatory field")
	private Gender gender;
	
	private Date dob;
	
	@NotBlank(message = "mandatory")
	private String address;
	
//	@NotBlank(message = "mendatory")
//	private String branch;
	
	@Valid
	private BranchProxy branch;
	
	private List<LocationProxy> location;
}
