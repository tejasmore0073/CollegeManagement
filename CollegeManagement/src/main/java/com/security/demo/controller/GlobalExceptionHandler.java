package com.security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.security.demo.exception.InvalidId;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<?>invalidId(InvalidId e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	
}
