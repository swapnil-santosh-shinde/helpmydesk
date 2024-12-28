package com.helpmy.desk.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	
	private int errorCode;
    private String errorMessage;
    private boolean success;


}
