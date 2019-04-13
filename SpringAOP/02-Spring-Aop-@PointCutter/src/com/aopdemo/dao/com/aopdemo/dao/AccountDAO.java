package com.aopdemo.dao.com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass()+": Doing my DB work, Adding an account.");
    }

    public void doWork(){
        System.out.println(getClass()+": DOING STUFF.");
    }
}
