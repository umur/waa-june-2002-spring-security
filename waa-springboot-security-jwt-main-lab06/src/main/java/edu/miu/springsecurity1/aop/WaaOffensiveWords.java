package edu.miu.springsecurity1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WaaOffensiveWords {
    @Pointcut("@annotation(edu.miu.springsecurity1.aop.annotation.OffensiveWords)")
    public void offensiveWords(){

    }
    @Around("offensiveWords()")
    public Object calculateExcutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish  = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName()+"take ns:"+(finish-start));
        return result;
    }
}
