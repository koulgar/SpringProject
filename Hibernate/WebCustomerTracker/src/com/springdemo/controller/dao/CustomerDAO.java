package com.springdemo.controller.dao;

import com.springdemo.controller.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomer(String searchName);

    List<Customer> findAndReplace(String searchName, String replaceName);
}
