package com.ems.employee.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ems.employee.domain.EmployeeInfo;
import com.ems.employee.domain.EmployeeProfileImage;
import com.ems.employee.proxy.EmployeeProfileImageProxy;
import com.ems.employee.proxy.ErrorData;
import com.ems.employee.repository.EmployeeRepo;
import com.ems.employee.repository.ProfileImageRepo;
import com.ems.employee.service.EmployeeService;
import com.ems.employee.utils.Helper;
import com.ems.employee.utils.ImportHelper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ProfileImageRepo imageRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public String uploadProfileImage(MultipartFile file, EmployeeInfo employeeInfo) {
		// TODO Auto-generated method stub
		EmployeeProfileImage empPid = new EmployeeProfileImage();
		empPid.setFileName(file.getName());
		empPid.setFileSize(file.getSize());
		empPid.setContentType(file.getContentType());
		try {
			empPid.setFileData(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String uuid = UUID.randomUUID().toString();
		System.out.println("uid = " + uuid);

		String originalFilename = file.getOriginalFilename();
		int lastIndexOf = originalFilename.lastIndexOf(".");
		String ext = originalFilename.substring(lastIndexOf);
		String finalFileId = uuid.concat(ext);
		empPid.setFileId(finalFileId);

		empPid.setEmployeeInfo(employeeInfo);
		imageRepo.save(empPid);
		return "saved :- " + finalFileId;
	}

	@Override
	public EmployeeProfileImageProxy downloadProfileImage(String fileId) {
		// TODO Auto-generated method stub
		Optional<EmployeeProfileImage> empPid = imageRepo.findByFileId(fileId);
		if (empPid.isPresent()) {
			return Helper.convertEntityToProxy(empPid.get());
		}
		ErrorData errd = ErrorData.builder().errorCode("9090").errorMessage("no record").build();
		return new EmployeeProfileImageProxy(errd);

	}

	@Override
	public String uploadImageToDynamicPath(MultipartFile myFile) {

		String fileName = null;
		EmployeeProfileImage empsave = null;
		try {

			// String
			// urlPath="C:\\Users\\VikramPrajapati\\Documents\\workspace-spring-tool-suite-4-4.27.0.RELEASE\\EMS_Employee\\src\\main\\resources\\static\\Document";

			String urlPath = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
					+ File.separator + "Document";

			File f = new File(urlPath);
			if (!f.exists()) {
				f.mkdir();
			}
			fileName = myFile.getOriginalFilename();
			String absolutePath = urlPath + File.separator + fileName;
			System.out.println(absolutePath);
			Files.copy(myFile.getInputStream(), Paths.get(absolutePath), StandardCopyOption.REPLACE_EXISTING);

			// save to db
			EmployeeProfileImage empPid = new EmployeeProfileImage();
			empPid.setContentType(myFile.getContentType());
			empPid.setFileData(null);
			empPid.setFileName(fileName);
//		String uuid = UUID.randomUUID().toString();
//		//System.out.println("uid = "+uuid);
//		
//		String originalFilename = myFile.getOriginalFilename();
//		int lastIndexOf = originalFilename.lastIndexOf(".");
//		String ext = originalFilename.substring(lastIndexOf);
//		String finalFileId=uuid.concat(ext);
//		empPid.setFileId(finalFileId);
			empPid.setFileId(null);
			// empPid.setFileId(UUID.randomUUID().toString().concat(myFile.getOriginalFilename().substring(myFile.getOriginalFilename().indexOf("."))));
			empPid.setFileSize((myFile.getSize() / 1000));
			empsave = imageRepo.save(empPid);
		}

		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "saved -> " + (Objects.isNull(empsave) ? "id not found" : empsave.getId());
	}

	@Override
	public EmployeeProfileImageProxy downloadImageFromDynamicPath(String fileId) {

		EmployeeProfileImage empPI = null;
		try {
			empPI = imageRepo.findById(Long.parseLong(fileId)).get();
			String urlPath = new ClassPathResource("").getFile().getAbsolutePath() + File.separator + "static"
					+ File.separator + "Document";
			String absolutePath = urlPath + File.separator + empPI.getFileName();
			byte[] allBytes = Files.readAllBytes(new File(absolutePath).toPath());
			empPI.setFileData(allBytes);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return Helper.convertEntityToProxy(empPI);
	}

	public void uploadMultiFile(MultipartFile[] file) {
		for (MultipartFile mf : file) {
			String result;
			// Files.copy(file.getClass(),StandardCopyOption.REPLACE_EXISTING(result));
			result = uploadImageToDynamicPath(mf);
			System.out.println(result);
		}
	}

	@Override
	public List<String> getFileName() {

		String[] fileName = {
				"C:\\Users\\VikramPrajapati\\Documents\\workspace-spring-tool-suite-4-4.27.0.RELEASE\\EMS_Employee\\target\\classes\\static\\Document\\tree.jpg",
				"C:\\Users\\VikramPrajapati\\Documents\\workspace-spring-tool-suite-4-4.27.0.RELEASE\\EMS_Employee\\target\\classes\\static\\Document\\eye.jpg" };

		List<String> fileList = new ArrayList<>(Arrays.asList(fileName));
		return fileList;
	}

	@Override
	public String saveObjectsFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			List<EmployeeInfo> empLists = ImportHelper.getListOfObjectFromExcel(file.getInputStream());
			employeeRepo.saveAll(empLists);
			return "saved successfully";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "not save";
	}

	@Override
	public List<EmployeeInfo> findAllEmployeeInfos() {
		// TODO Auto-generated method stub
		List<EmployeeInfo> all = employeeRepo.findAll();
		return all;
	}

	@Override
	public byte[] getExcelFileOfObjects() {
		// TODO Auto-generated method stub
		List<EmployeeInfo> all = employeeRepo.findAll();
		return ImportHelper.downloadExcelFromDatabase(all);
	}

	@Override
	public byte[] downloadExcelBlankFile() {
		// TODO Auto-generated method stub
		try {
			String urlPath=new ClassPathResource("static/Document").getFile().getAbsolutePath();
			String finalUrl=urlPath+File.separator+"new_emp.xlsx";
			return Files.readAllBytes(new File(finalUrl).toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
