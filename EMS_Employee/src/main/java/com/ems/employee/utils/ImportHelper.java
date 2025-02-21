package com.ems.employee.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ems.employee.domain.EmployeeInfo;

public class ImportHelper {

	public static List<EmployeeInfo> getListOfObjectFromExcel(InputStream is) {
		List<EmployeeInfo> empList = new ArrayList<>();

		try {
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheetAt(0);
			sheet.removeRow(sheet.getRow(0));
			for (Row row : sheet) {
				EmployeeInfo emp = new EmployeeInfo();
				emp.setEmpid(row.getCell(0).getStringCellValue());
				emp.setName(row.getCell(1).getStringCellValue());
				emp.setDob(Integer.parseInt(NumberToTextConverter.toText(row.getCell(2).getNumericCellValue())));
				emp.setMobileno(NumberToTextConverter.toText(row.getCell(3).getNumericCellValue()));
				emp.setGender(row.getCell(4).getStringCellValue());
				emp.setAddress(row.getCell(5).getStringCellValue());
				empList.add(emp);
			}
			workbook.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return empList;
	}
	
	public static byte[] downloadExcelFromDatabase(List<EmployeeInfo>empinfo) {
		
		final String sheetName = "EmpREcord";
		final String[]headers= {"empid","name","dob","gender","address"};
		
		try {
			Workbook work = new XSSFWorkbook();
			Sheet sheet = work.createSheet(sheetName);
			Row row = sheet.createRow(0);
			for(int i=0;i<headers.length;i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(headers[i]);
			}
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			
			int rowCount=1;
			for(EmployeeInfo emp:empinfo) {
				Row row2 = sheet.createRow(rowCount);
				
				row2.createCell(0).setCellValue(emp.getEmpid());
				row2.createCell(1).setCellValue(emp.getName());
				row2.createCell(2).setCellValue(emp.getDob());
				row2.createCell(3).setCellValue(emp.getMobileno());
				row2.createCell(4).setCellValue(emp.getGender());
				row2.createCell(5).setCellValue(emp.getAddress());
				rowCount++;
			}
			work.write(byteArrayOutputStream);
			work.close();
			//byteArrayOutputStream.close();
			return byteArrayOutputStream.toByteArray();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
//{
//"empid":"001",
//"name":"raju",
//"dob":"2000",
//"gender":"MALE",
//"address":"ahd"
//}