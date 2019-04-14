package com.aopdemo.service;

import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {
        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //return a fortune
        return "Expect heavy traffic this morning";
    }


    public String getFortune(Boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Major accident! Highway is closed!");
        }

        return getFortune();
    }
}
