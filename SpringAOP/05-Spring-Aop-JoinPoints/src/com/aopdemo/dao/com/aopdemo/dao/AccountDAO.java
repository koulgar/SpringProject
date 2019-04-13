package com.aopdemo.dao.com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

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
