package com.sms.student.service;

import java.util.List;
import com.sms.student.proxy.BranchProxy;

public interface BranchServices {

	public String saveBranch(BranchProxy branch);
	public BranchProxy getById(Long bid);
	public List<BranchProxy> getAllBranch();
	public String updateBranchById(Long bid,BranchProxy br);
	public void deleteBranchById(Long bid);
}
