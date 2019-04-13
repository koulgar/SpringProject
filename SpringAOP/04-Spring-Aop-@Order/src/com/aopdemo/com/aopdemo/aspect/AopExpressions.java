package com.aopdemo.com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.aopdemo.dao.com.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.aopdemo.dao.com.aopdemo.dao.*.set*(..))")
    public void forSetter(){}

    @Pointcut("execution(* com.aopdemo.dao.com.aopdemo.dao.*.get*(..))")
    public void forGetter(){}

    @Pointcut("forDaoPackage() && !(forSetter()||forGetter())")
    public void forDaoPackageExceptSetterAndGetters(){}


}
