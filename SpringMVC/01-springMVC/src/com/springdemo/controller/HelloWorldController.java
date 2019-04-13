package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //need a controller method to show the initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //new controller method to read form data and
    //add data to the model
    @RequestMapping("/processFormVersion2")
    public String cheerWelcomeV2(HttpServletRequest request, Model model){
        //read the request parameter from the HTML form
        String name = request.getParameter("studentName");
        //convert data to all upper case
        name = name.toUpperCase();
        //create the message
        String result = "Hello! " + name;
        //add messade to the model
        model.addAttribute("message",result);
        return "helloworld";
    }

    @RequestMapping("/processFormVersion3")
    public String cheerWelcomeV3(@RequestParam("studentName") String name, Model model){
        //convert data to all upper case
        name = name.toUpperCase();
        //create the message
        String result = "Hello!!! " + name;
        //add messade to the model
        model.addAttribute("message",result);
        return "helloworld";
    }
}
