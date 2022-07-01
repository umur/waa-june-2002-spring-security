package com.springjwt.aspect.Exception;

public class OffensiveException extends RuntimeException{
    public OffensiveException(String message) {
        super(message);
    }
}
