package com.ems.employee.proxy;

import java.sql.Date;

import com.ems.employee.domain.EmployeeInfo;
import com.ems.employee.domain.EmployeeProfileImage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(Include.NON_EMPTY)
public class EmployeeProfileImageProxy {

	private Long id;
	private String fileName;
	private String fileId;
	private Long fileSize;
	private String contentType;
	
	private ErrorData errorData;
	private Date date;
	public EmployeeProfileImageProxy(ErrorData errorData) {
		super();
		this.errorData = errorData;
	}
	private byte[] fileData;
	
	private EmployeeInfo employeeInfo;
	
}
