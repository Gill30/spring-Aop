package com.example.aop.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
@Aspect
//Configuration
@Configuration
public class AfterAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method I want to interspect
    //execution(* PACKAGE.*.*(..))

    @After("com.example.aop.Aspect.JavaPointConfig.dataLayerExecution()") //Before needs point cut, which tell which method this method will interspect
    public void after(JoinPoint joinPoint){
        //What to do
        logger.info(" After - Intercepted Method call - {}", joinPoint);
    }

    @AfterReturning(
            value="execution(* com.example.aop.business.*.*(..))",
        returning = "result"
    ) //Before needs point cut, which tell which method this method will interspect
    public void afterReturing(JoinPoint joinPoint, Object result){
        //What to do
        logger.info(" AfterReturing - Intercepted Method call - {} - {}", joinPoint, result);
    }

    @AfterThrowing(
            value="execution(* com.example.aop.business.*.*(..))",
            throwing = "exception"
    ) //Before needs point cut, which tell which method this method will interspect
    public void afterthrowing(JoinPoint joinPoint, Exception exception){
        //What to do
        logger.info(" AfterReturing - Intercepted Method call - {} - {}", joinPoint, exception);
    }
}

//the process which implementing this aspect around your joinPoint is called Weaving.
//and the spring framework which is doing this implementation is called Weaver.

//JoinPoint : What kind of method we want to intercept.
// Advice : What we are suppose to do in our aspect
//Aspect : JoinPoint + advice