package com.cooper.springdatajpa.log;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Pointcut;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PointcutConstants {

    @Pointcut("execution(* com.cooper.springdatajpa..SalaryRepository.getSumOfSalariesPerEmployee(..))")
    public void sumOfSalariesStopWatchPointCut() {}

}
