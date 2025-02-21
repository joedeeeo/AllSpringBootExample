package com.sms.student.controller;

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

import com.sms.student.proxy.BranchProxy;
import com.sms.student.service.BranchServices;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchServices branchServices;
	
	@PostMapping("/saveBranch")
	public String saveBranch(@RequestBody BranchProxy branch) {
		return branchServices.saveBranch(branch);
	}
	
	@GetMapping("/getAllBranch")
	public List<BranchProxy> getAllBranch(){
		return branchServices.getAllBranch();
	}
	
	@GetMapping("getById/{bid}")
	public BranchProxy getById(@PathVariable Long bid) {
		return branchServices.getById(bid);
	}
	
	@PutMapping("/updateBranchById/{bid}")
	public String updateBranchById(@PathVariable Long bid,@RequestBody BranchProxy br) {
		return branchServices.updateBranchById(bid, br);
	}
	
	@DeleteMapping("/deleteBranchById/{bid}")
	public void deleteBranchById(@PathVariable Long bid) {
		branchServices.deleteBranchById(bid);
	}
}
