package com.example.aop.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
@Aspect
//Configuration
@Configuration
public class BeforeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method I want to interspect
    //execution(* PACKAGE.*.*(..))

    @Before("execution(* com.example.aop.business.*.*(..))") //Before needs point cut, which tell which method this method will interspect
    public void before(JoinPoint joinPoint){
        //What to do
        logger.info(" Intercepted Method call - {}", joinPoint);
    }
}

//the process which implementing this aspect around your joinPoint is called Weaving.
//and the spring framework which is doing this implementation is called Weaver.

//JoinPoint : What kind of method we want to intercept.
// Advice : What we are suppose to do in our aspect
//Aspect : JoinPoint + advice