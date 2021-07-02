package com.example.application1.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_shoes")
public class OrderShoes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "shoes_id")
    private Integer shoesId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "price")
    private Integer price;

    public OrderShoes() {

    }

    public OrderShoes(Integer orderId, Integer shoesId, Integer quantity, Integer price) {
        this.orderId = orderId;
        this.shoesId = shoesId;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getShoesId() {
        return shoesId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }

}
