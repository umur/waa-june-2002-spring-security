package com.pprajapati.springsecurity.exceptionHandler.exceptions;

public class OffensiveWordException extends RuntimeException {
  public  OffensiveWordException(String message) {
    super(message);
  }
}
