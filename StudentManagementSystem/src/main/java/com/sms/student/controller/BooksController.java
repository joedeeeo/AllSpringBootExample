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

import com.sms.student.proxy.BooksProxy;
import com.sms.student.service.BooksService;

@RestController
@RequestMapping("/book")
public class BooksController {

	@Autowired
	private BooksService booksService;
	
	@PostMapping("/saveBook")
	public String saveBook(@RequestBody BooksProxy book) {
		return booksService.saveBook(book);
	}
	
	@GetMapping("/getBookById/{id}")
	public BooksProxy getBookById(@PathVariable Long id) {
		return booksService.getBookById(id);
	}
	
	@GetMapping("/getAllBook")
	public List<BooksProxy> getAllBooks() {
		return booksService.getAllBooks();
	}
	
	@PutMapping("/updateBookById/{id}")
	public String updateBookById(@PathVariable Long id,@RequestBody BooksProxy b) {
		return booksService.updateBookById(id, b);
	}
	
	@DeleteMapping("/deleteBookById")
	public String deleteBookById(@PathVariable Long id) {
		return booksService.deleteBookById(id);
	}
}
