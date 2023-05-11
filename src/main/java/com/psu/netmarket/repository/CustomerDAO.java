package com.psu.netmarket.repository;

import com.psu.netmarket.model.Customer;

import java.util.List;

public interface CustomerDAO {

    // insert
    void insertCustomer(Customer customer);

    // read
    Customer findCustomerByUserName(String name);
    List<Customer> findAllCustomers();
    List<Customer> findCustomersByCountry(String country);

    // update
    void updateCustomer(Customer customer);

    // delete
    void deleteCustomer(String userName);
    int deleteAllCustomer();
}
