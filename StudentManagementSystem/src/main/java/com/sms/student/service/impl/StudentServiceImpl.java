package com.sms.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.student.creationenum.ErrorDetails;
import com.sms.student.domain.Student;
import com.sms.student.global.exception.EmptyListException;
import com.sms.student.proxy.StudentProxy;
import com.sms.student.repo.StudentRepo;
import com.sms.student.service.StudentServices;
import com.sms.student.util.MapperUtils;

@Service
public class StudentServiceImpl implements StudentServices{

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private MapperUtils mapper;
	
	@Override
	public String saveStudent(StudentProxy student) {
		Student s= mapper.convertSProxyToSEntity(student);
		s.getLocation().stream().forEach(l->l.setStudent(s));
		studentRepo.save(s);
		//studentRepo.save(mapper.convertSProxyToSEntity(student));
		return "student add successfully";
	}

	@Override
	public List<StudentProxy> getAllStudent() {
		// TODO Auto-generated method stub
		List<StudentProxy>s=mapper.convertSListEntityToSProxy(studentRepo.findAll());
		if(s.isEmpty()) {
			throw new EmptyListException(ErrorDetails.EMPTY_RECORD.getErrMsg(),
					ErrorDetails.EMPTY_RECORD.getErrCode().toString()); 
		}else {
			return s;
		}
	}

	@Override
	public String updateStudentById(Long sid, StudentProxy std) {
		// TODO Auto-generated method stub
		Optional<Student> s = studentRepo.findById(sid);
		if(s.isPresent()) {
			Student st=s.get();
			st.setName(std.getName());
			st.setGender(std.getGender());
			st.setAddress(std.getAddress());
			st.setDob(std.getDob());
			
			st.getBranch().setDescription(std.getBranch().getDescription());
			st.getBranch().setName(std.getBranch().getName());
			studentRepo.save(st);
				return "data update successfully";
			}
		else {
			return "no student on this id";
		}
	}
	
	@Override
	public String deleteStudentById(Long sid) {
		// TODO Auto-generated method stub
		//studentRepo.deleteById(sid);
		Optional<Student> s=studentRepo.findById(sid);
		if(s.isPresent()) {
			studentRepo.deleteById(sid);
			return "student deleted successfully on given studentID";
		}
		else {
			return "studentID is not available";
		}
	}

	
}
