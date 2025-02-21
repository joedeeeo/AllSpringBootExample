package com.sms.student.creationenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorDetails {
	
	NOT_FOUND(1080,"data not found"),
	EMPTY_RECORD(1160,"DB is empty"),
	NOT_SET(102,"Gender allow only MALE or FEMALE");
	
	private Integer errCode;
	private String errMsg;
	
}
