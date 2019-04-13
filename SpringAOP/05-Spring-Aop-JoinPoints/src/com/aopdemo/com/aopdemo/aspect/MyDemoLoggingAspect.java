package com.aopdemo.com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.aopdemo.com.aopdemo.aspect.AopExpressions.forDaoPackageExceptSetterAndGetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("=====>> Executing @Before advice on addAccount()");
        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //display method arguments
        System.out.println("Method: "+methodSignature);
        //get args
        Object[] args =joinPoint.getArgs();
        //loop thru args
        for(Object tempArgs: args){
            System.out.println(tempArgs);
            if(tempArgs instanceof Account){
                //downcast and print Account Spesific Stuff
                Account account = (Account) tempArgs;
                System.out.println("account name: "+account.getName());
                System.out.println("account level: "+account.getLevel());
            }
        }
    }
}