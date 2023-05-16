package com.psu.netmarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderItemId implements Serializable {

    @Column(name = "product_upc", nullable = false)
    private Long productUpc;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

}
