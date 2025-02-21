package com.BMS.controller;

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
import com.BMS.Service.BookService;
import com.BMS.entity.Book;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/createbook")
	public String createbook(@RequestBody Book book) {
		return bookService.createbook(book);
	}
	
	@GetMapping("/getallbook")
	public List<Book> getallbook() {
		return bookService.getallbook();
	}
	
	@GetMapping("/getbookbyid/{bookid}")
	public Book getbookbyid(@PathVariable Long bookid) {
		return bookService.getbookbyid(bookid);
	}
	
	@PutMapping("/updatebookbyid/{bookid}/{bookname}")
	public Book updatebookbyid(@PathVariable Long bookid,@PathVariable String bookname) {
		return bookService.updatebookbyid(bookid, bookname);
	}
	
	@DeleteMapping("/deletebookbyid/{bookid}")
	public void deletebyid(@PathVariable long bookid) {
		System.out.println("delete successfully");
		bookService.deletebyid(bookid);
		
	}
}
