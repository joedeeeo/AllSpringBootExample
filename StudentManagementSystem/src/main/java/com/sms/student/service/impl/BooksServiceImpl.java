package com.sms.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.student.domain.Books;
import com.sms.student.proxy.BooksProxy;
import com.sms.student.repo.BooksRepo;
import com.sms.student.service.BooksService;
import com.sms.student.util.MapperUtils;

@Service
public class BooksServiceImpl implements BooksService{

	
	@Autowired
	private BooksRepo booksRepo;
	
	@Autowired
	private MapperUtils mapper;
	
	@Override
	public String saveBook(BooksProxy book) {
		// TODO Auto-generated method stub
		Books b = mapper.convertBProxyToAEntity(book);
		booksRepo.save(b);
		return "Book added successfully";
	}

	@Override
	public BooksProxy getBookById(Long id) {
		// TODO Auto-generated method stub
		Books b = booksRepo.findById(id).get();
		return mapper.convertBEntityToBProxy(b);
	}

	@Override
	public List<BooksProxy> getAllBooks() {
		// TODO Auto-generated method stub
		List<BooksProxy>b=mapper.convertBoLEntityToAProxy(booksRepo.findAll());
		if(b.isEmpty()) {
			return null;
		}else {
			return b;
		}
	}

	@Override
	public String updateBookById(Long id, BooksProxy b) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String deleteBookById(Long id) {
		// TODO Auto-generated method stub
		booksRepo.deleteById(id);
		return "Book deleted successfully";
	}

}
