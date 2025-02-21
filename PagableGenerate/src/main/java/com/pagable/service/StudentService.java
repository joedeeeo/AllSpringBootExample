package com.pagable.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pagable.domain.Student;
import com.pagable.proxy.StudentProxy;

public interface StudentService {

	public String saveStudent(StudentProxy student);
	public List<StudentProxy> getAllStudent();
	public String saveBulkStudent(Integer noOfStudents);
	public List<StudentProxy> getAllSortedStudent(String attribute);
	public Page<Student> getPageWiseStudent(Integer pagenumber,Integer  pagesize);
	public Page<Student> getSortedStudent(Integer pagenumber,Integer pagesize,String attribute);
	public List<StudentProxy>queryMethod();
//	public String testTransactional(StudentProxy student);
	public Student createStudent(Student student);
}
