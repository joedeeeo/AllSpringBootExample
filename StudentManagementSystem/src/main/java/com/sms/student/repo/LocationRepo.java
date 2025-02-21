package com.sms.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.student.domain.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long>{

}
