package com.carwash.exception;

public class CarWashException extends Exception {

	private String code;
	
	public CarWashException() {
		// TODO Auto-generated constructor stub
	}

	public CarWashException(String code, String message) {
		super(message);
		this.code = code;
	}
	
	public CarWashException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CarWashException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CarWashException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CarWashException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

}
