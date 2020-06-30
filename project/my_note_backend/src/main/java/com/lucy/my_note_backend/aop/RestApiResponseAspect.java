package com.lucy.my_note_backend.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RestApiResponseAspect {

    @AfterReturning(value = "execution(* com.lucy.my_note_backend.controller.*.*(..))", returning = "returnValue")
    public void onAfterRestApiController(JoinPoint joinPoint, String returnValue ) {
        System.out.println("after");
        System.out.println(returnValue);
    }
}
