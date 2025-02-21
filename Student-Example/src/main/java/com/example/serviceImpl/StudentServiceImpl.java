package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.creation_enum.ErrorDetails;
import com.example.entity.Student;
import com.example.exception.EmptyListException;
import com.example.proxy.StudentProxy;
import com.example.repository.StudentRepo;
import com.example.service.StudentService;
import com.example.util.Helper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private Helper helper;

	@Override
	public String addStudent(StudentProxy student) {
		// TODO Auto-generated method stub
		studentRepo.save(helper.convertProxyToEntity(student));
		return "student add successfully";
	}

	@Override
	public List<StudentProxy> getAllStudent() {
		// TODO Auto-generated method stub
		List<StudentProxy> s = helper.convertListEntityToProxy(studentRepo.findAll());
		if (s.isEmpty()) {
			throw new EmptyListException(ErrorDetails.EMPTY_RECORD.getErrMsg(),
					ErrorDetails.EMPTY_RECORD.getErrCode().toString());
		} else {
			return s;
		}
	}

	@Override
	public StudentProxy getByStudentId(Long studentId) {
		// TODO Auto-generated method stub
		Optional<Student> stdOptional = studentRepo.findById(studentId);
		if (stdOptional.isPresent()) {
			return helper.convertEntityToProxy(stdOptional.get());
		}
		throw new EmptyListException(ErrorDetails.NOT_FOUND.getErrMsg(),
				ErrorDetails.NOT_FOUND.getErrCode().toString());
	}

	@Override
	public String updatestudentbyid(Long studentId, StudentProxy std) {
		// TODO Auto-generated method stub
		Optional<Student> stdbyId = studentRepo.findById(studentId);
		if (stdbyId.isPresent()) {
			Student stdtable = stdbyId.get();
			System.out.println("Student Proxy : " + std);

			if (!std.equals(null)) {
				if (std.getName() != null && !std.getName().isEmpty()) {
					stdtable.setName(std.getName());
				}
				if (std.getAddress() != null && !std.getAddress().isEmpty()) {
					stdtable.setAddress(std.getAddress());
				}
				if (std.getAge() != 0 && std.getAge() != null) {
					stdtable.setAge(std.getAge());
				}
				if (std.getPincode() != 0 && std.getPincode() != null) {
					stdtable.setPincode(std.getPincode());
				}
				if (std.getEmail() != null && !std.getEmail().isEmpty()) {
					stdtable.setEmail(std.getEmail());
				}
				System.out.println("student model :" + stdtable);
				studentRepo.save(stdtable);
				return "student record saved successfully";
			} else {
				return "not update";
			}
		}

		else {
			return "no student on this id";
		}
	}

	@Override
	public void deletebyid(Long StudentId) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(StudentId);
	}

	@Override
	public void deleteall() {
		// TODO Auto-generated method stub
		studentRepo.deleteAll();
	}

}
