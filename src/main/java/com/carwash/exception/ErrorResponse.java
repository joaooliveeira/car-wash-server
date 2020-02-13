package com.carwash.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	private String code;
	private String message;
	
	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	public ErrorResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

}
