package com.cs545waa.lab06.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OffensiveUserAspect {
    @Pointcut("execution(* com.cs545waa.lab06.controller..*(..))")
    private void httpRequest(){}

    @Around("httpRequest()")
    public Object monitorOffensiveUser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        return proceedingJoinPoint.proceed();
    }
}
