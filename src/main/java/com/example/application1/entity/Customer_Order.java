package com.example.application1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Customer_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "order_id")
    private UUID orderId;

    public Customer_Order() {

    }

    class Customer{
        @OneToMany
        private List<Order> orders;
    }

    class Order{
        @ManyToOne
        private Customer customer;
    }
    public Customer_Order(UUID id,UUID customerId,UUID orderId) {
        this.id = id;
        this.customerId = customerId;
        this.orderId = orderId;
    }

}
