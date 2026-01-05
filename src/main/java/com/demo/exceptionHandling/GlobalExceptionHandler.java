package com.demo.exceptionHandling;

import java.time.LocalDateTime;

import com.demo.respository.ResumeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<ApiError> handleBadRequest(BadRequest exception){
		
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
			
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> ResourceNotFoundHandler(ResourceNotFoundException exception){
		
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), LocalDateTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidateErrors(MethodArgumentNotValidException  exception){
		
		String errorMessage = exception.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(err -> err.getField() + " : "+ err.getDefaultMessage())
				.findFirst()
				.orElse("Validation Failed ...");
				
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(),exception.getMessage(),LocalDateTime.now());
		
		return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	// Generic Exception (FallBack)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleGenericException(Exception exception){
		
		ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Something went wrong. Please try again later...", LocalDateTime.now());
		
		return new ResponseEntity<ApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
