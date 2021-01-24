package com.example.aop.Aspect;

import org.aspectj.lang.annotation.Pointcut;

public class JavaPointConfig {

    @Pointcut("execution(* com.example.aop.DAO.*.*(..))")
    public  void dataLayerExecution(){}

    @Pointcut("execution(* com.example.aop.business.*.*(..))")
    public  void businessLayerExecution(){}

    @Pointcut("com.example.aop.Aspect.JavaPointConfig.businessLayerExecution() && com.example.aop.Aspect.JavaPointConfig.dataLayerExecution()")
    public  void allLayerExecution(){}

    //Following pointcut will interspect all Beans cantaining Data in them.
    @Pointcut("bean(*Data*)")
    public void beanContainingData(){};

    //Following will interspect all calls with data Layer
    @Pointcut("within(com.example.aop.DAO..*)")
    public void dataLayerExecutionWithWithin(){ }

    @Pointcut("@annotation(com.example.aop.Aspect.TimeTrack)")
    public void trackTimeAnnotation(){}
}
