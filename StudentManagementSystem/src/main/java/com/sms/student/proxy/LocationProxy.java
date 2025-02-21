package com.sms.student.proxy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class LocationProxy {

	private Long lid;
	@NotBlank(message = "mandatory")
	private String road;
	@NotBlank(message = "mandatory")
	private String area;
	
	private StudentProxy student;
}
