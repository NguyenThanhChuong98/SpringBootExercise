package com.example.application1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "shoes_order")
public class Shoes_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "shoes_id",insertable = true,updatable = true)
    private UUID shoesId;

    @Column(name = "order_id",insertable = true,updatable = true)
    private UUID orderId;

    public Shoes_Order() {

    }

    class Shoes {
        @ManyToMany
        private List<Order> orders;
    }

    class Order {
        @ManyToMany
        private List<Shoes> shoes;
    }

    public Shoes_Order(UUID id,UUID shoesId, UUID orderId) {
        this.id = id;
        this.shoesId = shoesId;
        this.orderId = orderId;


    }
}
