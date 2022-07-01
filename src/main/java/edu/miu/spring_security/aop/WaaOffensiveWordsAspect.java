package edu.miu.spring_security.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WaaOffensiveWordsAspect {

    public static int badWordsNumber = 0;
    @Before("execution(* edu.miu.spring_security.service.*.*(..))")
    public void checkOffensiveWords(JoinPoint joinPoint) throws Exception {


    }
}
