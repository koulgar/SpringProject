package com.springboot.demo.springboot.demoapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    //expose "/" that return "hello world"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time on server is "+ LocalDateTime.now();
    }
}
