package com.hero.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hero.entity.SuperHero;
import com.hero.service.SuperHeroService;
import com.hero.validation.SuperHeroValidation;

@RestController
@RequestMapping("/home")
public class SuperHeroController {

	@Autowired
	private SuperHeroService superHeroService;
	
	@Autowired
	private SuperHeroValidation superHeroValidation;
	
//	@PostMapping("/addsuperhero")
//	public String addSuperHero(@RequestBody SuperHero superHero) {
//		if(superHeroValidation.validateId(superHero.getId())&&superHeroValidation.validateUserName(superHero.getUserName())&&superHeroValidation.validateName(superHero.getName())
//				&&superHeroValidation.validateGender(superHero.getGender())&&superHeroValidation.validateEmailId(superHero.getEmailId())&&superHeroValidation.validateMovies(superHero.getMovies())
//				&&superHeroValidation.validateMobile(superHero.getMobileNo())&&superHeroValidation.validateAddress(superHero.getAddress())&&superHeroValidation.validatePincode(superHero.getPinCode())) {
//			return superHeroService.addSuperHero(superHero);
//		}else {
//			return "Object likely null or not match the criteria";
//		}
//	}
	
	@PostMapping("/addsuperhero")
	public String addSuperHero(@RequestBody SuperHero superHero) {
		if(superHeroValidation.validateId(superHero.getId())) return "Id is empty or less then 0";
		if(superHeroValidation.validateUserName(superHero.getUserName())) return "User name is empty or less then minimum value";
		if(superHeroValidation.validateName(superHero.getName())) return "Name likely null or empty";
		if(superHeroValidation.validateGender(superHero.getGender())) return "Gender should not be empty";
		if(!superHeroValidation.validateEmailId(superHero.getEmailId())) return "EmailId pattern not match";
		if(!superHeroValidation.validateMovies(superHero.getMovies())) return "Movie can not empty";
		if(!superHeroValidation.validateMobile(superHero.getMobileNo())) return "Length mismatch of the mobile number";
		if(!superHeroValidation.validateAddress(superHero.getAddress())) return "Address should not empty";
		if(superHeroValidation.validatePincode(superHero.getPinCode())) return "Pincode is mandatory";
		return superHeroService.addSuperHero(superHero);
	}
	
	@GetMapping("/getallsuperhero")
	public List<SuperHero> getAllSuperHeros() {
		return superHeroService.getAllSuperHeros();
	}
	
	@GetMapping("/getsuperherobyid/{id}")
	public SuperHero getSuperHeroById(@PathVariable Long id) {
		if(superHeroValidation.validateId(id)) {
			return superHeroService.getSuperHeroById(id);
		}
		else {
			return null;
		}
	}
	
	@PutMapping("/updatesuperherobyid/{id}")
	public SuperHero updateSuperHeroById(@PathVariable Long id, @RequestBody String userName) {
		if(superHeroValidation.validateId(id)) {
			return superHeroService.getSuperHeroById(id);
		}
		return null;
	}
	
	@DeleteMapping("/deletesuperherobyid/{id}")
	public void deleteSuperHeroById(Long id) {
		if(superHeroValidation.validateId(id)) {
			superHeroService.deleteSuperHeroById(id);
		}
		else {
			System.out.println("id not found");
		}
	}
	
	@DeleteMapping("/deleteallsuperhero")
	public void deleteAllSuperHero(SuperHero superHero) {
		superHeroService.deleteAllSuperHero(superHero);
	}
	
	
	
}
