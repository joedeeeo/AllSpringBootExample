package com.sms.student.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.student.domain.Authors;
import com.sms.student.domain.Books;
import com.sms.student.domain.Branch;
import com.sms.student.domain.Location;
import com.sms.student.domain.Student;
import com.sms.student.proxy.AuthorsProxy;
import com.sms.student.proxy.BooksProxy;
import com.sms.student.proxy.BranchProxy;
import com.sms.student.proxy.LocationProxy;
import com.sms.student.proxy.StudentProxy;

@Component
public class MapperUtils {

	@Autowired
	private ObjectMapper mapper;
	
	
	
	
	//student
	public StudentProxy convertSEntityToSProxy(Student std) {
		std.getBranch().setStudent(null);
		std.getLocation().stream().forEach(l -> l.setStudent(null));
		return mapper.convertValue(std, StudentProxy.class);
	}
	
	public Student convertSProxyToSEntity(StudentProxy std) {
		return mapper.convertValue(std, Student.class);
	}
	
	public List<StudentProxy> convertSListEntityToSProxy(List<Student> liststd){
		return liststd.stream().map(b->convertSEntityToSProxy(b)).collect(Collectors.toList());
	}
	
	
	
	//branch
	public BranchProxy convertBEntityToBProxy(Branch b) {
//	    if (b.getStudent() != null) {
//	        b.getStudent().setBranch(null);
//	    }
//	    return mapper.convertValue(b, BranchProxy.class);
		b.getStudent().setBranch(null);
		b.getStudent().getLocation().stream().forEach(l->l.setStudent(null));
		return mapper.convertValue(b, BranchProxy.class);
	}

	
	public Branch convertBProxyToBEntity(BranchProxy b) {
		return mapper.convertValue(b, Branch.class);
	}
	
	public List<BranchProxy> convertBListEntityBToProxy(List<Branch> listb){
		return listb.stream().map(b->convertBEntityToBProxy(b)).collect(Collectors.toList());
	}
	
	//location
	public LocationProxy convertlEntityTolProxy(Location lo) {
		//lo.getStudent().setLocation(null);
		lo.getStudent().setLocation(null);
		lo.getStudent().getBranch().setStudent(null);
		return mapper.convertValue(lo, LocationProxy.class);
	}
	
	public Location convertlProxyTolEntity(LocationProxy lo) {
		return mapper.convertValue(lo, Location.class);
	}
	
	public List<LocationProxy> convertlListEntityTolProxy(List<Location> listlo){
		return listlo.stream().map(l->convertlEntityTolProxy(l)).collect(Collectors.toList());
	}
	
	//author
	public AuthorsProxy convertAEntityToAProxy(Authors au) {
		au.getBooks().stream().forEach(a->a.setAuthors(null));
		return mapper.convertValue(au, AuthorsProxy.class);
	}
	
	public Authors convertAProxyToAEnyity(AuthorsProxy au) {
		return mapper.convertValue(au, Authors.class);
	}
	
	public List<AuthorsProxy> convertAListEntityToAProxy(List<Authors>listauthor){
		return listauthor.stream().map(a->convertAEntityToAProxy(a)).collect(Collectors.toList());
	}
	
	//books
	public BooksProxy convertBEntityToBProxy(Books bo) {
		return mapper.convertValue(bo, BooksProxy.class);
	}
	
	public Books convertBProxyToAEntity(BooksProxy bo) {
		//bo.getAuthors().stream().forEach(b->b.setBooks(null));
		
		return mapper.convertValue(bo, Books.class);
	}
	
	public List<Books> convertBoListEntityToBProxy(List<BooksProxy>listbook){
		return listbook.stream().map(b->convertBProxyToAEntity(b)).collect(Collectors.toList());
	}

	public List<BooksProxy>convertBoLEntityToAProxy(List<Books>listbook){
		return listbook.stream().map(b->convertBEntityToBProxy(b)).collect(Collectors.toList());
	}
//	public Collection<? extends Books> convertBListEntityBToProxy(List<BooksProxy> books, Class<Books> class1) {
//		// TODO Auto-generated method stub
//		return books.stream().map(b->convertBoProxyToAEntity(b)).collect(Collectors.toList());
//	}
	
}
	