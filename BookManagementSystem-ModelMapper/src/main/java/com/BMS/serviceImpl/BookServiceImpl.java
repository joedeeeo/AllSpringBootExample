package com.BMS.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BMS.Service.BookService;
import com.BMS.entity.Book;
import com.BMS.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public String createbook(Book book) {
		bookRepo.save(book);
		return "added successfully";
		
	}

	@Override
	public List<Book> getallbook() {
		return bookRepo.findAll();
	}

	@Override
	public Book getbookbyid(Long bookid) {
		return bookRepo.findById(bookid).orElse(null);
	}

	@Override
	public Book updatebookbyid(Long bookid, String bookname) {
		Optional<Book>b=bookRepo.findById(bookid);
		if(b.isPresent()) {
			Book bo = b.get();
			bo.setBookname(bookname);
			return bo;
		}
		return null;
	}

	@Override
	public void deletebyid(Long bookid) {
		bookRepo.deleteById(bookid);
	}

	
}
