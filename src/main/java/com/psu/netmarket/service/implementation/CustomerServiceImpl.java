package com.psu.netmarket.service.implementation;

import com.psu.netmarket.model.Customer;
import com.psu.netmarket.repository.CustomerDAO;
import com.psu.netmarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }

    @Override
    public Customer findCustomerByUserName(String name) {
        return customerDAO.findCustomerByUserName(name);
    }
}
