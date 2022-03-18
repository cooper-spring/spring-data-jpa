package com.cooper.springdatajpa.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Around("PointcutConstants.sumOfSalariesStopWatchPointCut()")
    public Object stopWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        log.debug("elapsed time : {}", stopWatch.getTotalTimeMillis());

        return result;
    }

}
