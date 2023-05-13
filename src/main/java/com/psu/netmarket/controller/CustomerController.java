package com.psu.netmarket.controller;

import com.psu.netmarket.exception.NotFoundException;
import com.psu.netmarket.model.Customer;
import com.psu.netmarket.repository.CustomerDAO;
import com.psu.netmarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/username/{userName}")
    public Customer getCustomerByUserName(@PathVariable String userName) {
        Customer customer = customerService.findCustomerByUserName(userName);
        if(customer == null)
            throw new NotFoundException("customer " + userName + " not found");
        return customer;
    }

}
