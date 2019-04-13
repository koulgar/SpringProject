package com.springdemo.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //add an initbinder.. to convert input strings
    //remove leading and trailing whitespace
    //resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/")
    public String showMainMenu(){
        return "main-menu";
    }

    @RequestMapping("/showForm")
    public String showForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer")
                                          Customer customer, BindingResult bindingResult){
        System.out.println("Last Name: |" + customer.getLastName()+"|");
        System.out.println("Binding result: " + bindingResult);
        System.out.println("\n\n\n");

        if(bindingResult.hasErrors()){
            return "customer-form";
        } else {
            return "customer-confirmation";
            }
    }
}
