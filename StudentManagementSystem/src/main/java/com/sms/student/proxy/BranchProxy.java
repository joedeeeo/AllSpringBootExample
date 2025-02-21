package com.sms.student.proxy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
public class BranchProxy {

	private Long bid;
	
	@NotBlank(message = "mendatory")
	private String name;
	
	@NotBlank(message = "mandatory")
	private String description;
	
	@Valid
	private StudentProxy student;
}
