package com.sms.student.domain;

import java.sql.Date;
import java.util.List;

import com.sms.student.creationenum.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private Date dob;
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branchid" , referencedColumnName = "bid")
	private Branch branch;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
	private List<Location> location;
}
