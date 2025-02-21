package com.sms.student.proxy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//@JsonInclude(Include.NON_NULL)
@JsonInclude(Include.NON_EMPTY)
public class AuthorsProxy {

	private Long id;
	private String name;
	private List<BooksProxy> books;
}
