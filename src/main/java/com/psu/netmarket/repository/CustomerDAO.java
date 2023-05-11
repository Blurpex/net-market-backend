package com.psu.netmarket.repository;

import com.psu.netmarket.model.Customer;

import java.util.List;

public interface CustomerDAO {
    void insert(Customer customer);
    Customer findByUserName(String name);
    List<Customer> findAllCustomers();
    List<Customer> findCustomersByCountry(String country);
}
