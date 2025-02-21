package com.sms.student.service;

import java.util.List;

import com.sms.student.proxy.AuthorsProxy;

public interface AuthorsService {

	public String saveAuthor(AuthorsProxy author);
	public AuthorsProxy getAuthorById(Long id);
	public List<AuthorsProxy> getAllAuthors();
	public String updateAuthorById(Long id,AuthorsProxy ap);
	public String deleteAuthorById(Long id);
}
