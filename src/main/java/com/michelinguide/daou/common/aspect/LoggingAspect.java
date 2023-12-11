package com.michelinguide.daou.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    
    @Around("within(com.michelinguide.daou..*)")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Signature signature = proceedingJoinPoint.getSignature();
        Object result = proceedingJoinPoint.proceed();

        log.info("{} ===========> REQUEST : {} > {}" , LocalDateTime.now()
                                                     , signature.getDeclaringTypeName()
                                                     , signature.getName());

        log.info("{} ===========> RESPONSE : {} > {} = {}", LocalDateTime.now()
                                                          , signature.getDeclaringTypeName()
                                                          , signature.getName()
                                                          , result);
        return result;
    }
}
