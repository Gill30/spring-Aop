package com.example.aop.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
@Aspect
//Configuration
@Configuration
public class AroundAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method I want to interspect
    //execution(* PACKAGE.*.*(..))

    @Around("execution(* com.example.aop.business.*.*(..))") //Before needs point cut, which tell which method this method will interspect
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object returnObject = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;

        //startTime  =x
        //allow execution of method
        //endTime = x

        //What to do
        logger.info(" Time Taken by  {} - {}", joinPoint, timeTaken);
        return returnObject;
    }


    @Around("com.example.aop.Aspect.JavaPointConfig.trackTimeAnnotation()") //Before needs point cut, which tell which method this method will interspect
    public Object timetrack(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime1 = System.currentTimeMillis();
        Object returnObject = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime1;

        //startTime  =x
        //allow execution of method
        //endTime = x

        //What to do
        logger.info(" Time Taken by @timeTrack annotation  {} - {}", joinPoint, timeTaken);
        return returnObject;
    }

}

//the process which implementing this aspect around your joinPoint is called Weaving.
//and the spring framework which is doing this implementation is called Weaver.

//JoinPoint : What kind of method we want to intercept.
// Advice : What we are suppose to do in our aspect
//Aspect : JoinPoint + advice