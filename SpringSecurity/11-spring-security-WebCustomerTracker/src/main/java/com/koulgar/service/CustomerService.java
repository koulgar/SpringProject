package com.koulgar.service;


import com.koulgar.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String searchName);

    List<Customer> findAndReplace(String findName, String replaceName);


}
