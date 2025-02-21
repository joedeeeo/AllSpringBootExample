package com.sms.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.student.domain.Authors;
import com.sms.student.proxy.AuthorsProxy;
import com.sms.student.repo.AuthorsRepo;
import com.sms.student.service.AuthorsService;
import com.sms.student.util.MapperUtils;

@Service
public class AuthorsServiceImpl implements AuthorsService{
	
	@Autowired
	private AuthorsRepo authorsRepo;
	
	@Autowired
	private MapperUtils mapper;

	@Override
	public String saveAuthor(AuthorsProxy author) {
		// TODO Auto-generated method stub
		Authors a = mapper.convertAProxyToAEnyity(author);
		authorsRepo.save(a);
		return "Author added successfully";
	}

	@Override
	public AuthorsProxy getAuthorById(Long id) {
		// TODO Auto-generated method stub
		Authors a=authorsRepo.findById(id).get();
		return mapper.convertAEntityToAProxy(a);
	}

	@Override
	public List<AuthorsProxy> getAllAuthors() {
		// TODO Auto-generated method stub
		List<AuthorsProxy>a= mapper.convertAListEntityToAProxy(authorsRepo.findAll());
		if (a.isEmpty()) {
			return null;
		}else {
			return a;
		}
	}

	@Override
	public String updateAuthorById(Long id, AuthorsProxy ap) {
		// TODO Auto-generated method stub
		Optional<Authors>a=authorsRepo.findById(id);
		if (a.isPresent()) {
			Authors au=a.get();
			au.setName(ap.getName());
			au.getBooks().stream().forEach(c->{
				ap.getBooks().stream().forEach(c2->{
					if (c.getId()==c2.getId()) {
						c.setName(c2.getName());
						c.setSsn(c2.getSsn());
						
					}
				});
			});
			authorsRepo.save(au);
			return "Author is successfully updated";
		}else {
			return "given id is not available or does not exist";
		}
	}

	@Override
	public String deleteAuthorById(Long id) {
		// TODO Auto-generated method stub
		authorsRepo.deleteById(id);
		return "deleted successfully";
		
	}

}
