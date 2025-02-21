package com.StudentCrud.service;

import java.util.List;

import com.StudentCrud.Model.Student;

public interface StudentService {

	public String addStudent(Student student);
	public List<Student> getAllStudent();
	public Student getByStudentId(Long studentId);
	public List<Student> updateByStudentId(Long studentId,String name,String address,int rollNo,int age);
	public List<Student> deleteByStudentId(Long studentId);
}
