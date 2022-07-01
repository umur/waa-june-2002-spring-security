package com.example.spring_jwt.exceptionHandler.exceptions;

public class OffensiveWordException extends RuntimeException {
  public  OffensiveWordException(String message) {
    super(message);
  }
}
