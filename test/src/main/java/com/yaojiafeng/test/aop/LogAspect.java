package com.yaojiafeng.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yaojiafeng
 * @create 2017-09-11 下午3:32
 */
@Aspect
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.yaojiafeng.test.aop.LogMDC)")
    public void log() {

    }

    @Around("log()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String interfaceName = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
        } finally {
            logger.info(interfaceName + "-" + methodName + "-" + obj + "-" + args);
        }
        return obj;
    }

}
