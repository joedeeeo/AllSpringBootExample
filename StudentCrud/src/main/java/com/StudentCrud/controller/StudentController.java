package com.StudentCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentCrud.Model.Student;
import com.StudentCrud.service.StudentService;

@RestController
@RequestMapping("/emp")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/addstudent")
	public String addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/getallstudent")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@GetMapping("/getstudentbyid/{StudentId}")
	public Student getByStudentId(@PathVariable Long StudentId) {
		return studentService.getByStudentId(StudentId);
	}
	
	@PutMapping("/updatebyid/{StudentId}/{name}/{address}/{rollNo}/{age}")
	public List<Student>updateByStudentId(@PathVariable Long StudentId,@PathVariable String name,@PathVariable String address,
			@PathVariable int rollNo,@PathVariable int age) {
		return studentService.updateByStudentId(StudentId, name, address, rollNo, age);
	}
	
	@DeleteMapping("/deletebyid/{StudentId}")
	public List<Student> deleteByStudentId(@PathVariable Long StudentId){
		return studentService.deleteByStudentId(StudentId);
	}
	
}
