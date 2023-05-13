package com.psu.netmarket.service;

import com.psu.netmarket.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomers();
    Customer findCustomerByUserName(String name);
}
