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

import com.sms.student.proxy.AuthorsProxy;
import com.sms.student.service.AuthorsService;

@RestController
@RequestMapping("/author")
public class AuthorsController {

	@Autowired
	private AuthorsService authorsService;
	
	@PostMapping("/saveAuthor")
	public String saveAuthor(@RequestBody AuthorsProxy author) {
		return authorsService.saveAuthor(author);
	}
	
	@GetMapping("/getAuthorById/{id}")
	public AuthorsProxy getAuthorById(@PathVariable Long id) {
		return authorsService.getAuthorById(id);
	}
	
	@GetMapping("/getAllAuthor")
	public List<AuthorsProxy> getAllAuthors() {
		return authorsService.getAllAuthors();
	}
	
	@PutMapping("/updateAuthorById/{id}")
	public String updateAuthorById(@PathVariable Long id,@RequestBody AuthorsProxy ap) {
		return authorsService.updateAuthorById(id, ap);
	}
	
	@DeleteMapping("/deleteAuthorById/{id}")
	public String deleteAuthorById(Long id) {
		return authorsService.deleteAuthorById(id);
	}
}
