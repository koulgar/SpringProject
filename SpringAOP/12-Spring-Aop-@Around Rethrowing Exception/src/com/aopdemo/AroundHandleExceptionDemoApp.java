package com.aopdemo;

import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundHandleExceptionDemoApp {

    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

        logger.info("\nMain Program: AroundDemoApp");
        logger.info("Calling getFortune");
        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        logger.info("\nMy fortune is: "+data);
        logger.info("Finished");

        //close context
        context.close();
    }
}
