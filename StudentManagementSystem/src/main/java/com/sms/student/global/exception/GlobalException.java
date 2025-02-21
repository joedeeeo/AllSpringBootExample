package com.sms.student.global.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sms.student.creationenum.ErrorDetails;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(EmptyListException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse emptyexception2(EmptyListException ex) {
		return new ErrorResponse(ex.getErrormsg(), ex.getErrorcode());
	}

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse emptyexception(NoSuchElementException ex) {
		return new ErrorResponse(ErrorDetails.EMPTY_RECORD.getErrMsg(),ErrorDetails.EMPTY_RECORD.getErrCode().toString());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.FOUND)
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> errMap = new HashMap<>();
		ex.getAllErrors().forEach(err->{
			String fieldName = ((FieldError)err).getField();
			String value = err.getDefaultMessage();
			errMap.put(fieldName, value);
		});
		return errMap;
	}
}
