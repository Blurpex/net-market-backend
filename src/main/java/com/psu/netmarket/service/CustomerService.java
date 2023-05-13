package com.psu.netmarket.service;

import com.psu.netmarket.model.Customer;

import java.util.List;

public interface CustomerService {
    void insertCustomer(Customer customer);
    List<Customer> findAllCustomers();
    Customer findCustomerByUserName(String name);
    void updateCustomer(Customer customer);
    void deleteCustomer(String userName);
    void deleteAllCustomer();
}
