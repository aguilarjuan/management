package com.nisum.management.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class MetricAspect {

    @Around("@annotation(com.nisum.management.aspect.LoggerMetric)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = proceedingJoinPoint.proceed();
        stopWatch.stop();

        log.info("invocation to class name: {}, method name: {}, time used: {} ms",
                methodSignature.getDeclaringType().getSimpleName(), methodSignature.getName(),
                stopWatch.getTotalTimeMillis());

        return proceed;
    }
}
