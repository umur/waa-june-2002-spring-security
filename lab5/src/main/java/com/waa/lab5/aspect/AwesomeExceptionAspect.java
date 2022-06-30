package com.waa.lab5.aspect;

import com.waa.lab5.excpetion.AopIsAwesomeHeaderException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AwesomeExceptionAspect {

    @Before("within(com.waa.lab5.service.*)")
    public void beforeAspect() {
        HttpServletRequest curRequest =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                        .getRequest();

        if (curRequest.getMethod().equals("POST") && curRequest.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException();
        }
    }

}
