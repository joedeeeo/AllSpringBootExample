package com.sms.student.service;

import java.util.List;

import com.sms.student.proxy.BooksProxy;

public interface BooksService {

	public String saveBook(BooksProxy book);
	public BooksProxy getBookById(Long id);
	public List<BooksProxy> getAllBooks();
	public String updateBookById(Long id,BooksProxy b);
	public String deleteBookById(Long id);
}
