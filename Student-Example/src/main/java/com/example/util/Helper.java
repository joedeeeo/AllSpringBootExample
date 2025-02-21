package com.example.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Student;
import com.example.proxy.StudentProxy;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Helper {

	@Autowired
	private ObjectMapper mapper;

	public StudentProxy convertEntityToProxy(Student std) {
		return mapper.convertValue(std, StudentProxy.class);
	}
	
	public Student convertProxyToEntity(StudentProxy std) {
		return mapper.convertValue(std, Student.class);
	}
	
	public List<StudentProxy> convertListEntityToProxy(List<Student> lstStd) {
		return lstStd.stream().map(s->mapper.convertValue(s, StudentProxy.class)).collect(Collectors.toList());
	}
}
