package com.pagable.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.pagable.domain.Student;
import com.pagable.proxy.StudentProxy;
import com.pagable.repository.StudentRepo;
import com.pagable.service.StudentService;
import com.pagable.util.Helper;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private Helper helper;

	@Override
	public String saveStudent(StudentProxy student) {
		// TODO Auto-generated method stub
		repo.save(helper.convertProxyToEntity(student));
		return "Student added successfully";
	}

	@Override
	public List<StudentProxy> getAllStudent() {
		// TODO Auto-generated method stub
		return helper.convertListOfEntityToProxy(repo.findAll());
	}

	@Override
	public String saveBulkStudent(Integer noOfStudents) {
		// TODO Auto-generated method stub
		for(int i=0;i<noOfStudents;i++) {
			repo.save((generateStudent()));
		}
		return noOfStudents+" student";
	}

	@Override
	public List<StudentProxy> getAllSortedStudent(String attribute) {
		// TODO Auto-generated method stub
		List<Student> all = repo.findAll(Sort.by(Sort.Direction.DESC,attribute));
		return helper.convertListOfEntityToProxy(all);
	}

	@Override
	public Page<Student> getPageWiseStudent(Integer pagenumber,Integer  pagesize) {
		// TODO Auto-generated method stub
		Page<Student> all = repo.findAll(PageRequest.of(pagenumber, pagesize));
		return all;
	}
	
	private Student generateStudent() {
		
		Faker f=new Faker();
		Student s=new Student();
		
		s.setFname(f.name().firstName());
		s.setLname(f.name().lastName());
		s.setDob(f.date().birthday().toString());
		s.setMobile(f.phoneNumber().phoneNumber());
		s.setEmail(f.name().firstName() + "_" + f.name().lastName() + "@gmail.com");
		s.setAddress(f.address().fullAddress());
		try {
			s.setPincode(Integer.parseInt(f.address().zipCode()));
		} catch (Exception e) {
			// TODO: handle exception
			s.setPincode(f.random().nextInt(1, 20));
		}
		return s;
		
	}
	
	@Override
	public Page<Student> getSortedStudent(Integer pagenumber,Integer pagesize,String attribute){
		Page<Student> all = repo.findAll(PageRequest.of(pagenumber, pagesize, Sort.by(Sort.Direction.DESC,attribute)));
		return all;
	}
	
	@Transactional
	public List<StudentProxy> queryMethod(){
		
		//return helper.convertListOfEntityToProxy(repo.findByFname("Stanton"));
		//return helper.convertListOfEntityToProxy(repo.findByLname("Dach"));
		//return helper.convertListOfEntityToProxy(repo.findByFnameAndLname("Brett", "Nitzsche"));
		//return helper.convertListOfEntityToProxy(repo.findByFnameOrLname("Nitzsche", "Dach"));
		//return helper.convertListOfEntityToProxy(repo.findByDobBetween("1993", "2007"));
		//return helper.convertListOfEntityToProxy(repo.findByFnameLike("A%"));
		//return helper.convertListOfEntityToProxy(repo.findByFnameNotLike("A%"));
		//return helper.convertListOfEntityToProxy(repo.findByFnameEndingWith("a%"));
		//return helper.convertListOfEntityToProxy(repo.findByEmail("Ellsworth_Larkin@gmail.com"));
		//return helper.convertListOfEntityToProxy(repo.findByPincode(51466));
//		List<Student> s= repo.findByPincode(51466);
//		repo.deleteByPincode(15);
//		//repo.deleteById(null);
//		return null;
		
		//return helper.convertListOfEntityToProxy(repo.getAllStudentsRecord());
//		Student s= repo.getStudentByEmail("Velvet_Gutkowski@gmail.com");
//		return helper.convertListOfEntityToProxy(List.of(s));
		
//		return helper.convertListOfEntityToProxy(repo.getStudentByFnameLname("Lyndon", "Schmidt"));
//		repo.deleteStudentByEmail("Delta_Hilll@gmail.com");
//		return null;
		
		//return helper.convertListOfEntityToProxy(repo.getStudentLimitedData());
		
//		repo.saveStudent();
//		repo.updateStudent("Vikram_Prajapati", 12991l);
//		return null;
		
		return helper.convertListOfEntityToProxy(repo.allNativeQuery("Vikram_Prajapati","Prajapati"));
	}
	
//	@Transactional
//	public String testTransactional(StudentProxy student) {
//		List<StudentProxy> s=helper.convertListOfEntityToProxy(repo.saveStudentTrancactional());
//		try {
//			s.isEmpty();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.getLocalizedMessage();
//		}
//		return "not insert";
//	}
	
	
	@Transactional
	public Student createStudent(Student student) {
        try {
            repo.createStudentByQuery(student.getFname(), student.getLname());
            	return student;
        } catch (Exception e) {
            throw new RuntimeException("Error while creating student", e);
        }
    }
	
}
