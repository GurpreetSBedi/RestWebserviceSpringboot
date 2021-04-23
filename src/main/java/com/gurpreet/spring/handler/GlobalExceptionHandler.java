package com.gurpreet.spring.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.gurpreet.spring.exceptions.APIErrorDetails;
import com.gurpreet.spring.exceptions.APIException;

@ControllerAdvice
public class GlobalExceptionHandler {


	private static final long serialVersionUID = 1L;

	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleAPIException(APIException exception, WebRequest request){
		APIErrorDetails errorDetails = new APIErrorDetails();
		errorDetails.setAdditionalDetails(String.format("API call failed from internal excution : {}", exception.getMessage()));
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setTimestamp(new Date());
		return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request){
		return new ResponseEntity(String.format("Global exception occurred due to internal excution failures: {}", 
									exception.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
