package com.pprajapati.springsecurity.exceptionHandler;

import com.pprajapati.springsecurity.exceptionHandler.exceptions.OffensiveWordException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(OffensiveWordException.class)
  ResponseEntity<Object> handleException(OffensiveWordException ex){
    return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
  }
}