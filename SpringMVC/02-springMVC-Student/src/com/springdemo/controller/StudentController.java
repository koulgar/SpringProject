package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;

@Controller
@RequestMapping("/student")
public class StudentController {

//    @Value refers to import in servlet-config file for id:countryOptions
//    and it will be passed to "/processForm" directly
    @Value("#{countryOptions}")
    private LinkedHashMap<String,String> countryOptions;

    @Value("#{favoriteLanguageOptions}")
    private LinkedHashMap<String,String> favoriteLanguage;

    @Value("#{operatingSystemOptions}")
    private LinkedHashMap<String,String> operatingSystem;

    @RequestMapping("/")
    public String mainMenu(){
        return "main-menu";
    }

    @RequestMapping("/showForm")
    public String showForm(Model theModel){
        //create a new student object
        Student theStudent = new Student();
        //add student object to the model
        theModel.addAttribute("student",theStudent);
        //add countryOptions to the model
        theModel.addAttribute("countryOptions", countryOptions);
        //add favoriteLanguage object to the model
        theModel.addAttribute("favoriteLanguage", favoriteLanguage);
        //add operatingSystem object to the model
        theModel.addAttribute("operatingSystem", operatingSystem);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student")Student student){
        //log the input data
        System.out.println("theStudent: " + student.getFirstName() +"\n"
                + student.getLastName()+"\n"
                + student.getCountry() +"\n"
                + student.getFavoriteLanguage()+"\n"
                + student.getOperatingSystem());
        return "student-confirmation";
    }
}
