package com.ems.employee.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ems.employee.domain.EmployeeInfo;
import com.ems.employee.proxy.EmployeeProfileImageProxy;

public interface EmployeeService {

	public String uploadProfileImage(MultipartFile file, EmployeeInfo employeeInfo);

	public EmployeeProfileImageProxy downloadProfileImage(String fileId);

	public String uploadImageToDynamicPath(MultipartFile myFile);

	public EmployeeProfileImageProxy downloadImageFromDynamicPath(String fileId);

	public void uploadMultiFile(MultipartFile[] file);

	public List<String> getFileName();

	public String saveObjectsFromExcel(MultipartFile file);
	
	public List<EmployeeInfo> findAllEmployeeInfos();
	
	public byte[] getExcelFileOfObjects();
	
	public byte[] downloadExcelBlankFile();
}
