package com.security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.security.demo.exception.InvalidEmail;
import com.security.demo.exception.InvalidId;
import com.security.demo.exception.InvalidMobileNumber;
import com.security.demo.exception.InvalidName;
import com.security.demo.exception.InvalidPassword;
import com.security.demo.exception.InvalidRoll;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<?>invalidId(InvalidId e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidRoll.class)
	public ResponseEntity<?>invalidRoll(InvalidRoll e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidName.class)
	public ResponseEntity<?>invalidName(InvalidName e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidPassword.class)
	public ResponseEntity<?>invalidPassword(InvalidPassword e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidMobileNumber.class)
	public ResponseEntity<?>invalidMobileNumber(InvalidMobileNumber e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidEmail.class)
	public ResponseEntity<?>invalidEmail(InvalidEmail e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	
}
