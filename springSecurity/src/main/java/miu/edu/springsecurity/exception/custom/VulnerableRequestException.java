package miu.edu.springsecurity.exception.custom;

import lombok.Getter;

@Getter
public class VulnerableRequestException extends RuntimeException {

    public VulnerableRequestException(String message){
        super(message);
    }
}
