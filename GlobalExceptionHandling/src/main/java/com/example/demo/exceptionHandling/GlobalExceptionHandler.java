package com.example.demo.exceptionHandling;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	MessageSource messageSource;
    
	
	// handle all exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse>handleAllError(Exception ex,HttpServletRequest request){
	    String msg = messageSource.getMessage("error.internal", null, Locale.getDefault());

		ErrorResponse error=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				msg, 
				System.currentTimeMillis(),
				request.getRequestURL().toString());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// custome respone class
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorResponse>resourceNotFound(ResourceNotFound re){
		ErrorResponse error=new ErrorResponse(HttpStatus.NOT_FOUND.value(),
				re.getMessage(), System.currentTimeMillis(), null);
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	//handle Illegal Arguments exception
	/*
		 * Always return consistent fields: status, message, timestamp, details
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, Object>>handleIllegalArg(IllegalArgumentException ex, HttpServletRequest request){
		Map<String, Object>custResponse=new HashMap<>();
		custResponse.put("status", HttpStatus.BAD_REQUEST);
		custResponse.put("massage", ex.getMessage());
		custResponse.put("timestamp", System.currentTimeMillis());
		custResponse.put("detail", request.getRequestURL());
		return new ResponseEntity<Map<String,Object>>(custResponse,HttpStatus.BAD_REQUEST);
		
	}
	
//	@ExceptionHandler(ProductNotFoundException.class)
//	public ResponseEntity<Map<String,Object>>errorResponse(ProductNotFoundException ex,HttpServletRequest request){
//		Map<String, Object>error=new HashMap<>();
//		error.put("status", HttpStatus.NOT_FOUND.value());
//		error.put("massage", "Product not Found");
//		error.put("timestamp", System.currentTimeMillis());
//		error.put("dtails", request.getRequestURI());
//		return new ResponseEntity<Map<String,Object>>(error,HttpStatus.NOT_FOUND);
//	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse>productResponse(ProductNotFoundException ex,HttpServletRequest request){
		ErrorResponse response=new ErrorResponse(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), System.currentTimeMillis(), request.getRequestURL().toString());
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	
	// handle validation exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> response(MethodArgumentNotValidException ex,HttpServletRequest request){
		 Map<String, String> fieldErrors = new HashMap<>();
	        ex.getBindingResult().getFieldErrors()
	                .forEach(error ->
	                        fieldErrors.put(error.getField(), error.getDefaultMessage())
	                );
		Map<String , Object> er=new HashMap<>();
		er.put("status", 400);
		er.put("timestamp", System.currentTimeMillis());
		er.put("errors", fieldErrors);
		return new ResponseEntity<Map<String,Object>>(er,HttpStatus.NOT_FOUND);
	}
	
	
	// Exception Hierarchy
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> hierechyExceprionHandling(ApiException ex,HttpServletRequest requset){
		ErrorResponse response=new ErrorResponse();
		response.setStatus(ex.getStatus().value());
		response.setMessage(ex.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		response.setDetails(requset.getRequestURL().toString());
		return new ResponseEntity<ErrorResponse>(response,ex.getStatus());
	}
}
