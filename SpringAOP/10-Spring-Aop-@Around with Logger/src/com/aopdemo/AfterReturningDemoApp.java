package com.aopdemo;

import com.aopdemo.dao.com.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

        //call method to find accounts
        List<Account> accounts = accountDAO.findAccounts(false);

        //display the accounts
        System.out.println("\nMain program: AfterReturningDemoApp");
        System.out.println("-----------");
        System.out.println(accounts);
        System.out.println("\n");

        //close context
        context.close();
    }
}
