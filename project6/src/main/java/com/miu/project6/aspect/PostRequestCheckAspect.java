package com.miu.project6.aspect;


import com.miu.project6.exception.AopIsAwesomeHeaderException;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@AllArgsConstructor
public class PostRequestCheckAspect {
    private final HttpServletRequest httpServletRequest;
    @Pointcut("within(com.example.lab5.service..*)")
    public void a(){}

    @Before("a()")
    public void headerCheck(JoinPoint joinPoint) throws Throwable{
        if(httpServletRequest.getMethod().equals("POST")&&httpServletRequest.getHeader("AOP-IS_AWESOME")==null){
            throw new AopIsAwesomeHeaderException("Header Exception");
        }
    }

}
