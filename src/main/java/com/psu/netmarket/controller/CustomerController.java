package com.psu.netmarket.controller;

import com.psu.netmarket.model.Customer;
import com.psu.netmarket.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerDAO.findAllCustomers();
    }

    @GetMapping("/{userName}")
    public Customer getCustomerByUserName(@PathVariable String userName) {
        return customerDAO.findCustomerByUserName(userName);
    }
}
