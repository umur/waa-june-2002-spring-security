package com.springjwt.aspect;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.List;

@Aspect
@Component
@AllArgsConstructor
@Slf4j
public class WaaOffensiveWords {

    private final List<String> offWords = List.of("spring", "springboot");
    @Pointcut("within(com.springjwt.controllers..*)")
    public void checker(){}

    @Around("checker()")
    public Object checking(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        if (request.getRequestURI().equals("/api/v1/products") && request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            for (Object ob: proceedingJoinPoint.getArgs()) {
                for (String s : offWords) {
                    if (ob.toString().contains(s)) {
                        Class<?> someClass = ob.getClass();
                        Field field = someClass.getDeclaredField("name");
                        field.setAccessible(true);
                        field.set(ob, "******" + field.get(ob).toString().substring(3));
                        System.out.println(field.get(ob).toString());
                    }
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
