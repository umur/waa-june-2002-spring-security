package com.waa.lab5.aspect;

import com.waa.lab5.entity.ActivityLog;
import com.waa.lab5.repo.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.Instant;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogRepository activityLogRepository;

    @SneakyThrows
    @Around("@annotation(com.waa.lab5.aspect.annotation.ExecutionTime)")
    public Object executionTime(ProceedingJoinPoint pjp) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var res = pjp.proceed();
        stopWatch.stop();

        var log = new ActivityLog();
        log.setTimestamp(Instant.now().getEpochSecond());
        log.setDuration(stopWatch.getTotalTimeMillis());

        activityLogRepository.save(log);

        return res;
    }

}
