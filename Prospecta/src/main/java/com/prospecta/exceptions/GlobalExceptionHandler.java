package com.prospecta.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(EntryException.class)
	 public ResponseEntity<MyErrorDetails> entryExceptionHandler(EntryException e, WebRequest req){

	     MyErrorDetails er = new MyErrorDetails(e.getMessage(), req.getDescription(false), LocalDateTime.now());
	     return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<MyErrorDetails> exceptionHandler(Exception e, WebRequest req){

	     MyErrorDetails er = new MyErrorDetails(e.getMessage(), req.getDescription(false), LocalDateTime.now());
	     return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(RuntimeException.class)
	 public ResponseEntity<MyErrorDetails> runtimeExceptionHandler(EntryException e, WebRequest req){

	     MyErrorDetails er = new MyErrorDetails(e.getMessage(), req.getDescription(false), LocalDateTime.now());
	     return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
	 }
	 
}
