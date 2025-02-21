package com.pagable.repository;

import java.beans.Transient;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pagable.domain.Student;
import com.pagable.proxy.StudentProxy;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

	//List<Student>findByFname(String fname);
	//List<Student>findByLname(String lname);
	//List<Student>findByFnameAndLname(String fname,String Lname);
	//List<Student>findByFnameOrLname(String fname,String Lname);
	//List<Student>findByDobBetween(String sdate,String edate);
	//List<Student>findByFnameLike(String fname);
	//List<Student>findByFnameNotLike(String fname);
	//List<Student>findByFnameEndingWith(String fname);
	//List<Student>findByEmail(String email);
	//List<Student> findByPincode(Integer pincode);
//	@Transactional
//	void deleteByPincode(Integer pincode);
	
	@Query(value = "SELECT s FROM Student s")
	List<Student>getAllStudentsRecord();
	
	@Query(value = "SELECT s FROM Student s WHERE s.email=:em")
	Student getStudentByEmail(@Param("em") String email);
	
	@Query(value = "SELECT s FROM Student s Where s.fname=:first AND s.lname=:last")
	List<Student>getStudentByFnameLname(@Param("first") String fname,@Param("last") String lname);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Student s WHERE email=:em")
	void deleteStudentByEmail(@Param("em") String email);
	
	@Query(value = "SELECT NEW Student(s.fname, s.lname) FROM Student s")
	List<Student>getStudentLimitedData();
	
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO Student(fname,lname,address,email)VALUES('vikram','Prajapati','kalupur','vpgmail.com')")
	List<Student> saveStudent();
	
	
	@Query(value = "INSERT INTO student (fname, lname) VALUES (:first, :last)", nativeQuery = true)
    String createStudentByQuery(@Param("first") String fname, @Param("last") String lname);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Student s SET s.fname=:Nn WHERE s.sid=:id")
	void updateStudent(@Param("Nn") String Newname,@Param("id") Long sid);
	
	//@Query(value = "select * from student",nativeQuery = true)
	//@Query(value = "select * from student where fname=?",nativeQuery = true)
	@Query(value = "select * from student where fname=? AND lname=?",nativeQuery = true)
	List<Student>allNativeQuery(String fname,String lname);
	

}
