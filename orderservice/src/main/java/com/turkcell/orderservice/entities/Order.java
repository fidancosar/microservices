package com.turkcell.orderservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue
    private int orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;


    @Column(name = "freight")
    private float freight;

    @Column(name = "inventory_code")
    private String inventoryCode;

    @Column(name = "amount")
    private int amount;

}
