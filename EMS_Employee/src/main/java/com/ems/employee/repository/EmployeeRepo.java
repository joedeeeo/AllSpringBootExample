package com.ems.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.employee.domain.EmployeeInfo;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeInfo, Long>{

}
