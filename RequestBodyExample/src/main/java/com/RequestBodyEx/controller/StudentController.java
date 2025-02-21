package com.RequestBodyEx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.RequestBodyEx.model.Student;

@RestController
@ResponseBody
@RequestMapping("/home")
public class StudentController {
	
	@PostMapping("/student")
	public String createStudent(@RequestBody Student student) {
		return "Student created : "+student.getName()+", Age : "+student.getAge();
	}
	
}
