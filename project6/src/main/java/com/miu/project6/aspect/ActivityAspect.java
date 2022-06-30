package com.miu.project6.aspect;


import com.miu.project6.dto.ActivityDto;
import com.miu.project6.service.ActivityService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Date;

@Aspect
@Component
@AllArgsConstructor
public class ActivityAspect {


    //@Autowired
    private final ActivityService activityService;

    @Pointcut("@annotation(com.miu.project6.annotation.ExecutionTime)")
    public void a(){};


    @Around("a()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start=System.nanoTime();
        System.out.println("join-point started");
        Object result=proceedingJoinPoint.proceed();
        //proceedingJoinPoint.proceed();
        //var result=proceedingJoinPoint.proceed()
        long finish=System.nanoTime();
        long duration=finish-start;
        System.out.println("join-point end");
        System.out.println(proceedingJoinPoint.getSignature().getName()+"Takes ns: "+ (finish-start));
        activityService.createActivity(new ActivityDto(new Date(),proceedingJoinPoint.getSignature().getName(),duration ));
        return result;
    }

}
