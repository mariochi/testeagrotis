 package com.moretti.testeagrotis.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.moretti.testeagrotis.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest rq){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),rq.getRequestURI());
		return ResponseEntity.status(status.value()).body(err);
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> IllegalArguments(IllegalArgumentException e, HttpServletRequest rq)
	{
		String error = "Invalid Arguments";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),rq.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
