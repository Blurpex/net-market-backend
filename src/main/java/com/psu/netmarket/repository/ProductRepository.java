package com.psu.netmarket.repository;

import com.psu.netmarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
