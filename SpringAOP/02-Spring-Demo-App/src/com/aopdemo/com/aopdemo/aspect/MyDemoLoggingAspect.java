package com.aopdemo.com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices for logging


    //let's start with an @Before advice
//    @Before("execution(public void add*())")
    @Pointcut("execution(* com.aopdemo.dao.com.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("=====>> Executing @Before advice on addAccount()");
    }
}