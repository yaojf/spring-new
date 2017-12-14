package com.yaojiafeng.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author yaojiafeng
 * @create 2017-09-11 下午3:32
 */
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.yaojiafeng.test.aop.LogMDC)")
    public void log() {

    }

    @Around("log()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("log Around Advice");
        Object obj = proceedingJoinPoint.proceed();
        return obj;
    }

}
