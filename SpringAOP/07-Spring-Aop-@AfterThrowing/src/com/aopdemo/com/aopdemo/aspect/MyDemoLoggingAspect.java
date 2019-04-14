package com.aopdemo.com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.aopdemo.dao.com.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc")
    public void afterThrowingFindAcoountService(JoinPoint joinPoint, Throwable exc){
        //print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=====>>> Executing @AfterThrowing on method: "+ method);
        //log on exception
        System.out.println("=====>>>result is: "+ exc);

    }

    @AfterReturning(pointcut = "execution(* com.aopdemo.dao.com.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning ="result")
    //add a new advice for @AfterReturning on the findAccounts method
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        //print which method are we advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=====>>> Executing @AfterReturning on method: "+ method);
        //print out the results of the method call
        System.out.println("=====>>>result is: "+ result);
        //post-process the data ... lets's modify it

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("=====>>>result is: "+ result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        for(Account account: result){
        //get uppercase version of name
        String upperName = account.getName().toUpperCase();
        //update results
        account.setName(upperName);
        }

    }

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