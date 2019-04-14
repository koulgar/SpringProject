package com.aopdemo.com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.aopdemo.service.*.getFortune(..))")
        public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        //print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("=====>>> Executing @Around on method: "+ method);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        //execute the method
        Object result = proceedingJoinPoint.proceed();
        //get end timestamp
        long end = System.currentTimeMillis();
        //compute duration and display it
        long duration = end - begin;
        logger.info("\n Duration: "+ duration/1000.0 + "seconds.");
        return result;
    }

    @After("execution(* com.aopdemo.dao.com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>>> Executing @After(finally) on method: "+ method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.aopdemo.dao.com.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc")
    public void afterThrowingFindAcoountService(JoinPoint joinPoint, Throwable exc){
        //print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>>> Executing @AfterThrowing on method: "+ method);
        //log on exception
        logger.info("=====>>>result is: "+ exc);

    }

    @AfterReturning(pointcut = "execution(* com.aopdemo.dao.com.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning ="result")
    //add a new advice for @AfterReturning on the findAccounts method
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        //print which method are we advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>>> Executing @AfterReturning on method: "+ method);
        //print out the results of the method call
        logger.info("=====>>>result is: "+ result);
        //post-process the data ... lets's modify it

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        logger.info("=====>>>result is: "+ result);
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
        logger.info("=====>> Executing @Before advice on addAccount()");
        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //display method arguments
        logger.info("Method: "+methodSignature);
        //get args
        Object[] args =joinPoint.getArgs();
        //loop thru args
        for(Object tempArgs: args){
            logger.info(tempArgs.toString());
            if(tempArgs instanceof Account){
                //downcast and print Account Spesific Stuff
                Account account = (Account) tempArgs;
                logger.info("account name: "+account.getName());
                logger.info("account level: "+account.getLevel());
            }
        }
    }
}