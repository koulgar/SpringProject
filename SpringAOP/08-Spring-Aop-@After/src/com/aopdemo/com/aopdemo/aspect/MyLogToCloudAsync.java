package com.aopdemo.com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLogToCloudAsync {

    @Before("com.aopdemo.com.aopdemo.aspect.AopExpressions.forDaoPackageExceptSetterAndGetters()")
    public void logToCloudAsync(){
        System.out.println("=====>> Executing Log to Cloud Async");
    }
}
