package com.aopdemo.dao.com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSillyMember(){
        System.out.println(getClass()+": Doing Stuff.");
        return true;
    }

    public void goToSleep(){
        System.out.println(getClass()+": Going to sleep.");
    }
}
