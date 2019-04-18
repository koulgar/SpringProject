package com.koulgar.controller;

import com.koulgar.entitiy.User;
import com.koulgar.service.UserService;
import com.koulgar.user.CrmUser;
import com.koulgar.validation.ValidEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationPage(Model model){
        model.addAttribute("crmUser",new CrmUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("crmUser")CrmUser crmUser, BindingResult bindingResult){
        //form validation
        if(bindingResult.hasErrors()){
            return "registration-form";
        }
        //check the database if user already exists
        User existing = userService.findByUserName(crmUser.getUserName());
        if(existing!=null) {
            Model model = (Model) new CrmUser();
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("registrationError", "User name already exists.");
            return "registration-form";
        }
        //save user in the database
        userService.save(crmUser);
        return "registration-confirmation";
    }

}
