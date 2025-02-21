package com.ems.employee.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ems.employee.domain.EmployeeInfo;
import com.ems.employee.proxy.EmployeeProfileImageProxy;
import com.ems.employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	@PostMapping("/upload")
//	public ResponseEntity<String> uploadProfileImage(@RequestParam("profileImage") MultipartFile file,@RequestBody EmployeeInfo employeeInfo) {
//		//return employeeService.uploadProfileImage(file);
//		//return ResponseEntity<>(employeeService.uploadProfileImage(file),HttpStatus.OK);
//		return ResponseEntity.status(HttpStatus.OK).body(employeeService.uploadProfileImage(file,employeeInfo));
//	}

	//upload the image and data of the employee 
	@PostMapping("/upload")
	public ResponseEntity<String> uploadProfileImage(@RequestParam("profileImage") MultipartFile file,
			@RequestParam("employeeInfo") String employeeInfoJson) {

		// JSON string to EmployeeInfo object
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeeInfo employeeInfo = null;

		try {
			employeeInfo = objectMapper.readValue(employeeInfoJson, EmployeeInfo.class);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid employee information format.");
		}

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.uploadProfileImage(file, employeeInfo));
	}

	
	//download file via fileId
	@GetMapping("/download/{fid}")
	public ResponseEntity<byte[]> downloadDocument(@PathVariable("fid") String fileId) {
		EmployeeProfileImageProxy dpi = employeeService.downloadProfileImage(fileId);
//		return ResponseEntity.status(HttpStatus.OK)
//				.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+dpi.getFileId()+"\"")
//				.body(dpi.getFileData());

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(dpi.getContentType()))
				.body(dpi.getFileData());
	}

	//upload file in the file system
	@PostMapping("/upload-to-dynamic-path")
	public ResponseEntity<String> uploadDocumentToPath(@RequestParam("profileImage") MultipartFile file) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.uploadImageToDynamicPath(file));
	}

	//download the file from the specific path
	@GetMapping("/download-path/{fid}")
	public ResponseEntity<byte[]> downloadDocumentFromPath(@PathVariable("fid") String fileId) {
		EmployeeProfileImageProxy dpi = employeeService.downloadImageFromDynamicPath(fileId);
		return ResponseEntity.status(HttpStatus.OK).header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + dpi.getFileName() + "\"").body(dpi.getFileData());

		// return
		// ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(dpi.getContentType())).body(dpi.getFileData());
	}

	//upload multiple file at single
	@PostMapping("/upload-multi-image")
	public void uploadMultiFile(@RequestParam(value = "multiImage") MultipartFile[] file) {
		employeeService.uploadMultiFile(file);
	}

	
	//download the mutltiple file in zip formate
	@GetMapping("/downloadZip")
	public void downloadFile(HttpServletResponse response) {
		response.setContentType("application/zip");
		response.setHeader("Content-Disposition", "attachment;filename=download.zip");
		response.setStatus(HttpServletResponse.SC_OK);

		List<String> fileNames = employeeService.getFileName();
		try (ZipOutputStream zippedOut = new ZipOutputStream(response.getOutputStream())) {
			for (String file : fileNames) {
				FileSystemResource resource = new FileSystemResource(file);

				ZipEntry e = new ZipEntry(resource.getFilename());
				e.setSize(resource.contentLength());
				e.setTime(System.currentTimeMillis());
				zippedOut.putNextEntry(e);
				StreamUtils.copy(resource.getInputStream(), zippedOut);
				zippedOut.closeEntry();
			}
			// zippedOut.finish();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//excel to database
	@PostMapping("/copy-from-excel")
	public ResponseEntity<?> uploadFromExcel(@RequestParam("data") MultipartFile file) {
		String result=null;
		if(file != null && file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			result = employeeService.saveObjectsFromExcel(file);
		}else {
			result="format not supported";
		}
		
		return new ResponseEntity<>(Map.of("status", result), HttpStatus.OK);
	}
	
	//get all employees from database
	@GetMapping("/get-all-employees")
	public ResponseEntity<List<EmployeeInfo>>findALlEmployees(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAllEmployeeInfos());
	}
	
	@GetMapping("/download-blank-format")
	public ResponseEntity<?>downloadExcelFormat(){
		final String fileName = "new_emp.xlsx";
		byte[] excelObject = employeeService.downloadExcelBlankFile();
		return ResponseEntity.status(HttpStatus.OK).header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + fileName + "\"").body(excelObject);
	}
	
	@GetMapping("/download-excel")
	public ResponseEntity<?>downloadExcelFileFromData(){
		final String fileName = "emp_data.xlsx";
		byte[] excelObject = employeeService.getExcelFileOfObjects();
		return ResponseEntity.status(HttpStatus.OK).header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + fileName + "\"").body(excelObject);
		
	}

}
