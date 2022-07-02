package com.cs545waa.lab06.aspect;

import com.cs545waa.lab06.entity.OffensiveRequest;
import com.cs545waa.lab06.repository.OffensiveRequestRepo;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@AllArgsConstructor
public class OffensiveAspect {
    private final HttpServletRequest request;
    private final OffensiveRequestRepo repo;
    private static List<String> offensiveWords=new ArrayList<>();
    static {
        offensiveWords.add("Spring");
        offensiveWords.add("JWT");
        offensiveWords.add("React");
    }
    @Pointcut("within(com.cs545waa.lab06.controller..*)")
    private void httpRequest(){}

    @Around("httpRequest()")
    public Object Log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // check if request arguments have any offensive words
        List<Object> x=Arrays.stream(proceedingJoinPoint.getArgs())
                .filter(arg-> {  //filtering request arguments
                   var matchedOffensiveWords = offensiveWords.stream()
                           //determining if the arg has any offensive word
                                    .filter(word->arg.toString().contains(word))
                                    .toList();
                    return matchedOffensiveWords.size()>0;
                })
                .toList();
        if(x.size()>0)
        {
                repo.save(new OffensiveRequest(null,
                        request.getUserPrincipal().getName(),
                        proceedingJoinPoint.getSignature().getName()));

        }
        var result=proceedingJoinPoint.proceed();
        return result;
    }
}
