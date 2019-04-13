package com.aopdemo.dao.com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    //add a new method: findAccounts()
    public List<Account> findAccounts(){
        List<Account> accounts = new ArrayList<>();
        //create sample accounts
        Account account1 = new Account("John","Silver");
        Account account2 = new Account("Mahdu","Platinum");
        Account account3 = new Account("Luca","Gold");
        //add accounts to list
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass()+": Doing my DB work, Adding an account.");
    }

    public void doWork(){
        System.out.println(getClass()+": DOING STUFF.");
    }

    public String getName() {
        System.out.println(getClass()+": in getName.");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in setName.");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": in getServiceCode.");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": in setServiceCode.");
        this.serviceCode = serviceCode;
    }
}
