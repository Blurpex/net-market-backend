package com.psu.netmarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetail {

    // entities
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_username")
    private Customer customerUsername;

    @Column(name = "total", precision = 25, scale = 2, nullable = false)
    private BigDecimal total;

    @Column(name = "time_ordered")
    private Timestamp timeOrdered;

    // foreign keys
    @OneToMany(mappedBy = "orderId")
    private Set<OrderItem> orderItems = new HashSet<>();

}
