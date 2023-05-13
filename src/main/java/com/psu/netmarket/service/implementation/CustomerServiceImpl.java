package com.psu.netmarket.service.implementation;

import com.psu.netmarket.model.Customer;
import com.psu.netmarket.repository.CustomerDAO;
import com.psu.netmarket.service.CustomerService;
import jakarta.transaction.Transactional;
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
    @Transactional
    public void insertCustomer(Customer customer) {
        this.customerDAO.insertCustomer(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }

    @Override
    public Customer findCustomerByUserName(String name) {
        return customerDAO.findCustomerByUserName(name);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        this.customerDAO.updateCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(String userName) {
        this.customerDAO.deleteCustomer(userName);
    }

    @Override
    @Transactional
    public void deleteAllCustomer() {
        this.customerDAO.deleteAllCustomer();
    }
}
