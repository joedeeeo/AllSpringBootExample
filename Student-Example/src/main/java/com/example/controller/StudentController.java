package com.example.controller;

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
import com.example.proxy.StudentProxy;
import com.example.repository.StudentRepo;
import com.example.service.StudentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
//@RequestMapping("/home")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addstudent")
	public String addStudent(@Valid @RequestBody StudentProxy student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/getallstudent")
	public List<StudentProxy> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/getstudentbyid/{studentId}")
	public StudentProxy getByStudentId(@PathVariable Long studentId) {
		return studentService.getByStudentId(studentId);
	}
	
	@DeleteMapping("/deletestudentbyid/{studentId}")
	public void deleteByStudentId(@PathVariable Long studentId){
		studentService.deletebyid(studentId);
	}
	
	@DeleteMapping("/deleteall")
	public void deleteall() {
		studentService.deleteall();
	}
	
	@PutMapping("/updatestudentbyid/{studentId}")
	public String updatestudentbyid(@PathVariable Long studentId, @RequestBody StudentProxy std) {
		return studentService.updatestudentbyid(studentId, std);
	}
}
