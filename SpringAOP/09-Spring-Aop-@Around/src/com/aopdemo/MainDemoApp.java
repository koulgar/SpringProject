package com.aopdemo;

import com.aopdemo.dao.com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        //call the business method
        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Plat");
        accountDAO.addAccount(account,true);

        accountDAO.doWork();

        //call getter and setter methods
        accountDAO.setName("xxx");
        accountDAO.setServiceCode("xxx");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        //call the membership method
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();

        //close context
        context.close();
    }
}
