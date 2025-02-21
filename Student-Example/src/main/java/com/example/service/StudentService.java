package com.example.service;

import java.util.List;


import com.example.proxy.StudentProxy;

public interface StudentService {

	public String addStudent(StudentProxy student);
	public List<StudentProxy> getAllStudent();
	public StudentProxy getByStudentId(Long studentId);
	public String updatestudentbyid(Long studentId, StudentProxy std);
	public void deletebyid(Long StudentId);
	public void deleteall();
}
