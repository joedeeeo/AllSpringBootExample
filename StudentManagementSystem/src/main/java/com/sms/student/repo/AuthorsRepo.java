package com.sms.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.student.domain.Authors;

@Repository
public interface AuthorsRepo extends JpaRepository<Authors, Long>{

}
