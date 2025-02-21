package com.example.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.creation_enum.ErrorDetails;

@RestControllerAdvice
public class GlobleException {

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleNosuchElementExcetion(NoSuchElementException ex) {
		return new ErrorResponse(ex.getMessage(),"2002");
	}
	
	@ExceptionHandler(EmptyListException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse emptylistexception(EmptyListException ex) {
		return new ErrorResponse(ex.getErrormsg(),ex.getErrorcode());
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse uniqueconstranterror (DataIntegrityViolationException ex) {
		return new ErrorResponse(ErrorDetails.DUPLICATE_VALUE.getErrMsg(),ErrorDetails.DUPLICATE_VALUE.getErrCode().toString());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public ErrorResponse notreadeable (HttpMessageNotReadableException ex) {
		return new ErrorResponse(ErrorDetails.NOT_SET.getErrMsg(),ErrorDetails.NOT_SET.getErrCode().toString());
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

