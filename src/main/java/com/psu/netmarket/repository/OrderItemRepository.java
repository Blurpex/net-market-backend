package com.psu.netmarket.repository;

import com.psu.netmarket.model.OrderItem;
import com.psu.netmarket.model.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {}
