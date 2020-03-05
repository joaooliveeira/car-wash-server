package com.carwash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CarWashExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ResponseBody
	@ExceptionHandler(CarWashException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	ErrorResponse carWashException(CarWashException e) {
		e.printStackTrace();
		ErrorResponse response = new ErrorResponse(e.getCode(), e.getLocalizedMessage());
		return response;
	}
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code =  HttpStatus.BAD_REQUEST)
	ErrorResponse exception(Exception e) {
		e.printStackTrace();
		ErrorResponse response = new ErrorResponse("Erro, por favor tente novamente");
		return response;
		
	}

}
