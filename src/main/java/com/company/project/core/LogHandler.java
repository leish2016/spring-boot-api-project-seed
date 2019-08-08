package com.company.project.core;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * @author leish
 */
@Slf4j
@Aspect
@Component
public class LogHandler {

    @Around("execution(* com.company.project.controller.*.*(..)) || execution(* com.company.project.core.*.*(..))")
    public Object showLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String clazz = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        StringBuilder param = new StringBuilder();
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (Object arg : joinPoint.getArgs()) {
                if(arg == null){
                    continue;
                }
                if (param.length() > 0) {
                    param.append(", ");
                }
                param.append(arg.getClass().getSimpleName());
                if (arg instanceof byte[]) {
                    arg = new String((byte[])arg);
                }
                param.append('=').append(arg.toString());
            }
        }
        Object result = new Object();
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            log.info("# [RT={}ms] -> [{}.{}({}),result={}]", (System.currentTimeMillis() - start), clazz, method, param.toString(),result);
        }
        return result;
    }
}
