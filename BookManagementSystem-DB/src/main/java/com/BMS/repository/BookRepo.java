package com.BMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BMS.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

}
