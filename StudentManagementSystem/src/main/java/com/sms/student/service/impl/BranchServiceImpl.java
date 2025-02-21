package com.sms.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.student.domain.Branch;
import com.sms.student.global.exception.EmptyListException;
import com.sms.student.proxy.BranchProxy;
import com.sms.student.repo.BranchRepo;
import com.sms.student.service.BranchServices;
import com.sms.student.util.MapperUtils;

@Service
public class BranchServiceImpl implements BranchServices{

	@Autowired
	private BranchRepo branchRepo;
	
	@Autowired
	private MapperUtils mapper; 
	
	@Override
	public String saveBranch(BranchProxy branch) {
		// TODO Auto-generated method stub
		
//		branchRepo.save(mapper.convertBProxyToBEntity(branch));
		Branch br = mapper.convertBProxyToBEntity(branch);
		br.getStudent().setBranch(br);
		branchRepo.save(br);
		return "branch add successfully";
	}
	
	@Override
	public BranchProxy getById(Long bid) {
		Branch b= branchRepo.findById(bid).get();
		return mapper.convertBEntityToBProxy(b);
	}

	@Override
	public List<BranchProxy> getAllBranch() {
		// TODO Auto-generated method stub
		List<BranchProxy>b=mapper.convertBListEntityBToProxy(branchRepo.findAll());
		if(b.isEmpty()) {
			return null;
		}
		else {
			return b;
		}
	}

	@Override
	public String updateBranchById(Long bid, BranchProxy br) {
		// TODO Auto-generated method stub
		Optional<Branch>b= branchRepo.findById(bid);
		if(b.isPresent()) {
			Branch bran=b.get();
			if(bran !=null) {
				if(br.getName()!=null && !br.getName().isEmpty()) {
					bran.setName(br.getName());
				}
				if(br.getDescription()!=null && !br.getDescription().isEmpty()) {
					bran.setDescription(br.getDescription());
				}
				branchRepo.save(bran);
				return "data successfully";
			}
			else {
				return "not update";
			}
			
		}
		else {
			return "id not available";
		}
	}

	@Override
	public void deleteBranchById(Long bid) {
		// TODO Auto-generated method stub
		branchRepo.deleteById(bid);
		
	}

	
}
