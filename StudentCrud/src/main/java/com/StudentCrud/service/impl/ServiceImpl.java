package com.StudentCrud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.StudentCrud.Model.Student;
import com.StudentCrud.service.StudentService;

@Service
public class ServiceImpl implements StudentService{

	List<Student>stud=new ArrayList<>();
	@Override
	public String addStudent(Student student) {
		stud.add(student);
		return "Student add successfully";
	}

	@Override
	public List<Student> getAllStudent() {
		return stud;
	}

	@Override
	public Student getByStudentId(Long studentId) {
		Optional<Student>s=stud.stream().filter(st->st.getStudentId().equals(studentId)).findFirst();
		if(s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
	}

	@Override
	public List<Student> updateByStudentId(Long studentId,String name,String address,int rollNo,int age) {
		Optional<Student>s=stud.stream().filter(st->st.getStudentId().equals(studentId)).findFirst();
		if(s.isPresent()) {
			Student stu = s.get();
			stu.setName(name);
			stu.setAddress(address);
			stu.setRollNo(rollNo);
			stu.setAge(age);
		}
		return stud;
	}

	@Override
	public List<Student> deleteByStudentId(Long studentId) {
		Optional<Student>s=stud.stream().filter(st->st.getStudentId().equals(studentId)).findFirst();
		if(s.isPresent()) {
			Student stu=s.get();
			stud.remove(stu);
		}
		return stud;
	}

	
}
