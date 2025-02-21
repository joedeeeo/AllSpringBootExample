package com.pagable.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pagable.domain.Student;
import com.pagable.proxy.StudentProxy;

@Component
public class Helper {

	@Autowired
	private ObjectMapper mapper;
	
	public Student convertProxyToEntity(StudentProxy std) {
		return mapper.convertValue(std, Student.class);
	}
	
	public StudentProxy convertEntityToProxy(Student std) {
		return mapper.convertValue(std, StudentProxy.class);
	}
	
	public List<StudentProxy> convertListOfEntityToProxy(List<Student>std){
		return std.stream().map(s->convertEntityToProxy(s)).collect(Collectors.toList());
	}
	
	public List<Student> convertListOfProxyToEntity(List<StudentProxy>std){
		return std.stream().map(s->convertProxyToEntity(s)).collect(Collectors.toList());
	}
}
