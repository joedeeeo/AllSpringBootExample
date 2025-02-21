package com.ems.employee.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.ems.employee.domain.EmployeeProfileImage;
import com.ems.employee.proxy.EmployeeProfileImageProxy;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helper {

	@Autowired
	private static ObjectMapper mapper;
	
	public static EmployeeProfileImageProxy convertEntityToProxy(EmployeeProfileImage employeeProfileImage) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(employeeProfileImage, EmployeeProfileImageProxy.class);
	}
	
	public static EmployeeProfileImage convertProxyToEntity(EmployeeProfileImageProxy employeeProfileImageproxy) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(employeeProfileImageproxy, EmployeeProfileImage.class);
	}

	public static EmployeeProfileImage convertProxyToEntity(EmployeeProfileImage empPid) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(mapper, EmployeeProfileImage.class);
	}
	
	
}
