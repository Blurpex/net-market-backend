package com.psu.netmarket.repository;

import com.psu.netmarket.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {}
