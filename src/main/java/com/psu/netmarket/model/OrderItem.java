package com.psu.netmarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {

    // entities
    @EmbeddedId
    private OrderItemId id;

    @MapsId("productUpc")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_upc", nullable = false)
    private Product productUpc;

    @MapsId("orderId")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderDetail orderId;

    @Column(name = "count")
    private Integer count;

}
