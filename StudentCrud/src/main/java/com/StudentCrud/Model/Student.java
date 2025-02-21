package com.StudentCrud.Model;

public class Student {

	private Long StudentId;
	private String name;
	private int age;
	private int rollNo;
	private String address;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(Long studentId, String name, int age, int rollNo, String address) {
		super();
		this.StudentId = studentId;
		this.name = name;
		this.age = age;
		this.rollNo = rollNo;
		this.address = address;
	}
	
	public Long getStudentId() {
		return StudentId;
	}
	public void setStudentId(Long studentId) {
		StudentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", name=" + name + ", age=" + age + ", rollNo=" + rollNo
				+ ", address=" + address + "]";
	}
	
	
}
