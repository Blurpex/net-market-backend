package com.psu.netmarket.controller;

import com.psu.netmarket.exception.NotFoundException;
import com.psu.netmarket.model.Customer;
import com.psu.netmarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
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

    @PostMapping("/post/customer")
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @PutMapping("/put/customer")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{userName}")
    public void deleteCustomer(@PathVariable String userName) {
        customerService.deleteCustomer(userName);
    }

}
