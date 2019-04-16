package com.springdemo.controller;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject the customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model model) {
        //get customers from dao
        List<Customer> customers = customerService.getCustomers();
        //add the customers to model
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAddCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId")int id) {
    customerService.deleteCustomer(id);
    return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName")String searchName,Model model){
        List<Customer> customers = customerService.searchCustomers(searchName);
        model.addAttribute("customers",customers);
        return "list-customers";
    }

    @GetMapping("/replace")
    public String findAndReplaceCustomers(@RequestParam("findName")String findName,
                                          @RequestParam("replaceName")String replaceName,
                                          Model model){
        List<Customer> customers = customerService.findAndReplace(findName,replaceName);
        model.addAttribute("customers",customers);
        return "list-customers";
        }

}
