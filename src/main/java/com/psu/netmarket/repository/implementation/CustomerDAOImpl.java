package com.psu.netmarket.repository.implementation;

import com.psu.netmarket.model.Customer;
import com.psu.netmarket.repository.CustomerDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // inserts a customer
    @Override
    @Transactional
    public void insert(Customer customer) {
        entityManager.persist(customer);
    }

    // returns a customer by the primary key
    @Override
    public Customer findByUserName(String username) {
        return entityManager.find(Customer.class, username);
    }

    // returns all customers ordered by their name
    @Override
    public List<Customer> findAllCustomers() {
        TypedQuery<Customer> query = entityManager.createQuery(
                "FROM Customer " +
                "ORDER BY name", Customer.class
        );
        return query.getResultList();
    }

    // returns customer from a given country
    @Override
    public List<Customer> findCustomersByCountry(String country) {
        TypedQuery<Customer> query = entityManager.createQuery(
                "FROM Customer " +
                "WHERE country = :countryParam " +
                "ORDER BY country", Customer.class
        );
        query.setParameter("countryParam", country);
        return query.getResultList();
    }
}