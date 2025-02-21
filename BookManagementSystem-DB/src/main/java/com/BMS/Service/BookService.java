package com.BMS.Service;

import java.util.List;
import com.BMS.entity.Book;

public interface BookService {

	public String createbook(Book book);
	public List<Book> getallbook();
	public Book getbookbyid(Long bookid);
	public Book updatebookbyid(Long bookid,String bookname);
	public void deletebyid(Long bookid);
	
}
