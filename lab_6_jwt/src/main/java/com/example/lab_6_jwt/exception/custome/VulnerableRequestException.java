package com.example.lab_6_jwt.exception.custome;

import lombok.Getter;

@Getter
public class VulnerableRequestException extends RuntimeException{

    public VulnerableRequestException(String message){
        super(message);
    }
}
