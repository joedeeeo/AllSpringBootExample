package com.sms.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.student.domain.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
