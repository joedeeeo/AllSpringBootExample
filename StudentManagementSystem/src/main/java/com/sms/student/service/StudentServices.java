package com.sms.student.service;

import java.util.List;

import com.sms.student.domain.Student;
import com.sms.student.proxy.StudentProxy;

public interface StudentServices {

	public String saveStudent(StudentProxy student);
	public List<StudentProxy> getAllStudent();
	public String updateStudentById(Long sid,StudentProxy std);
	public String deleteStudentById(Long sid);
	
}
