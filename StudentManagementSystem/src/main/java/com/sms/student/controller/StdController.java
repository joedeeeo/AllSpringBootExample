package com.sms.student.controller;

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

import com.sms.student.domain.Student;
import com.sms.student.proxy.StudentProxy;
import com.sms.student.service.StudentServices;

@RestController
@RequestMapping("/Student")
public class StdController {

	@Autowired
	private StudentServices studentServices;
	
	@PostMapping("/saveStudent")
	public String saveStudent(@RequestBody StudentProxy student) {
		return studentServices.saveStudent(student);
	}
	
	@GetMapping("/getAllStudent")
	public List<StudentProxy> getAllStudent(){
		return studentServices.getAllStudent();
	}
	
	@PutMapping("/updateStudentById/{sid}")
	public String updateStudentById(@PathVariable Long sid,@RequestBody StudentProxy std) {
		return studentServices.updateStudentById(sid, std);
	}
	
	@DeleteMapping("/deleteStudentById/{sid}")
	public String deleteStudentById(@PathVariable Long sid) {
		return studentServices.deleteStudentById(sid);
	}
	
}
