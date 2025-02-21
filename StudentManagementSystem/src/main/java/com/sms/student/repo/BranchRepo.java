package com.sms.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.student.domain.Branch;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long>{

}
