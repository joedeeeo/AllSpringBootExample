package com.sms.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.student.domain.Books;

@Repository
public interface BooksRepo extends JpaRepository<Books, Long>{

}
