package com.sms.student.global.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	@Getter
	@Setter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	@Component
	public class EmptyListException extends RuntimeException{
		private static final long serialVersionUID = 1L;
		private String errormsg;
		private String errorcode;
		
}
