package com.psu.netmarket.controller;

import com.psu.netmarket.exception.ErrorResponse;
import com.psu.netmarket.exception.NotFoundException;
import com.psu.netmarket.model.Customer;
import com.psu.netmarket.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    @GetMapping("/username/{userName}")
    public Customer getCustomerByUserName(@PathVariable String userName) {
        Customer customer = customerDAO.findCustomerByUserName(userName);
        if(customer == null)
            throw new NotFoundException("customer " + userName + " not found");
        return customer;
    }

}
