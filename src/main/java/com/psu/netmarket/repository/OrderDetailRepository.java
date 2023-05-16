package com.psu.netmarket.repository;

import com.psu.netmarket.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "orderdetails")
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {}
