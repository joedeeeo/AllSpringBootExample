package com.pagable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagable.domain.Student;
import com.pagable.proxy.StudentProxy;
import com.pagable.service.StudentService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/generate-student/{noOfStudents}")
	public String saveBulkStudent(@PathVariable Integer noOfStudents) {
		return studentService.saveBulkStudent(noOfStudents);
	}
	
	@PostMapping("/save-student")
	public String saveStudent(@RequestBody StudentProxy student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/getall-student")
	public List<StudentProxy> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@GetMapping("/getall-student-sorted/{attribute}")
	public List<StudentProxy> getAllSortedStudent(@PathVariable String attribute) {
		return studentService.getAllSortedStudent(attribute);
	}
	
	@GetMapping("/get-student/{pagenumber}/{pagesize}")
	public Page<Student> getPageWiseStudent(@PathVariable Integer pagenumber,@PathVariable Integer  pagesize) {
		return studentService.getPageWiseStudent(pagenumber,pagesize);
	}
	
	@GetMapping("/get-sorted-student/{pagenumber}/{pagesize}/{attribute}")
	public Page<Student> getSortedStudent(@PathVariable Integer pagenumber,@PathVariable Integer  pagesize,@PathVariable String attribute) {
		return studentService.getSortedStudent(pagenumber,pagesize,attribute);
	}
	
	@GetMapping("/findmethod")
	public List<StudentProxy> queryMethod(){
		return studentService.queryMethod();
	}
	
//	@PostMapping("/findmethodTransactional")
//	public String transactional(@RequestBody StudentProxy student){
//		return studentService.testTransactional(student);
//	}
	
	@PostMapping("/findmethodTransactional")
    public Student createStudent(@RequestBody Student student) {
        try {
            return studentService.createStudent(student);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating student");
        }
    }
	
}
