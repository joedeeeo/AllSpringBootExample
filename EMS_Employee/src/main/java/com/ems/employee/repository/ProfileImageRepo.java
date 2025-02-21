package com.ems.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.employee.domain.EmployeeProfileImage;

@Repository
public interface ProfileImageRepo extends JpaRepository<EmployeeProfileImage, Long>{

	Optional<EmployeeProfileImage>findByFileId(String fileId);
}
