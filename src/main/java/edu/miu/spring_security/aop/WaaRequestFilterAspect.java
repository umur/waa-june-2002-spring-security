package edu.miu.spring_security.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WaaRequestFilterAspect {

    @Before("execution(* edu.miu.spring_security.service.*.*(..))")
    public void requestFilter (JoinPoint joinPoint) throws Exception {

    }
}
