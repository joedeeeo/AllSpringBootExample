package com.example.proxy;

import org.hibernate.validator.constraints.Range;

import com.example.creation_enum.Location;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProxy {

	private Long studentId;
	
	@NotBlank(message = "name field is mandatory")
	@Size(min = 3,max = 20,message = "name should be in 3 to 20 characters")
	private String name;
	
	@NotBlank(message = "address field is mandatory")
	private String address;
	
	@NotNull(message = "age should be gretter than or equal to 13")
	@Range(min = 10,max = 30)
	private Integer age;
	
	@NotNull(message = "pincode field is mandatory")
	@Range(min = 100000,max = 999999,message = "pincode length should be 6 length")
	private Integer pincode;

	@Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "not valid email pattern")
	private String email;

	private Location location;
}
