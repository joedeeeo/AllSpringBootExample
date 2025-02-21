package com.hero.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
@Component
public class SuperHeroValidation {

	public boolean validateId(Long id) {
		return id != null && id < 0;
	}
	
	public boolean validateUserName(String userName) {
		return userName != null && userName.isEmpty() && userName.length()>=5;
	}
	
	public boolean validateName(String name) {
		return name != null && name.isEmpty();
	}
	
	public boolean validateGender(String Gender) {
		return Gender != null && Gender.isEmpty();
	}
	
//	public boolean validateGender(String Gender) {
//		if(Gender == null || Gender.isEmpty()) {
//			return false;
//		}
//		else {
//			return true;
//		}
//	}
	
	public boolean validateEmailId(String emailId) {
		String emailpattern = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(emailpattern);
		Matcher matcher = pattern.matcher(emailId);
		return matcher.matches();
	}
	
	public boolean validateMovies(String movies) {
		return movies != null || movies.isEmpty();
	}
	
	public boolean validateMobile(Long mobileNo) {
		if(mobileNo == null) return false;
		String mstr = mobileNo.toString();
		return mstr.length() == 10 && mstr.matches("[0-9]{10}");
	}
	
	public boolean validateAddress(String address) {
		return address != null && !address.isEmpty();
	}
	
	public boolean validatePincode(String pinCode) {
		return pinCode != null && pinCode.isEmpty();
	}
}
