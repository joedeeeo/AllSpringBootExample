package com.example.creation_enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorDetails {
	
	NOT_FOUND(1080,"data not found"),
	EMPTY_RECORD(1160,"DB is empty"),
	NOT_SET(102,"location allow only GOA or DELHI"),
	DUPLICATE_VALUE(108,"duplicate EMAIL found");
	
	private Integer errCode;
	private String errMsg;
	
}
