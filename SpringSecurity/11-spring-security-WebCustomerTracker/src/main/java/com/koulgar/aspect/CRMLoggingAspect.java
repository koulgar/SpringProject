package com.koulgar.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());
    //setup pointcut declarations for CONTROLLER
    @Pointcut("execution(* com.koulgar.controller.*.*(..))")
    private void forControllerPackage(){

    }

    //setup pointcut declarations for SERVICE
    @Pointcut("execution(* com.koulgar.service.*.*(..))")
    private void forServicePackage(){

    }

    //setup pointcut declarations for DAO
    @Pointcut("execution(* com.koulgar.dao*.*(..))")
    private void forDaoPackage(){

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){

    }

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        //display the arguments to the method
        logger.info("====>> in @Before: calling method: "+method);
        //display the arguments to the method
        //get the arguments
        Object[] args = joinPoint.getArgs();
        //loop thru and display args
        for(Object tempArgs : args){
            logger.info("========>>> argument: "+ tempArgs);
        }
    }

    //add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        //display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        //display the arguments to the method
        logger.info("====>> in @AfterReturning: from method: "+method);
        //display the data returned
        //get the arguments
        logger.info("====>> result: "+ result);
        }
}
