package com.example.application1.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "order_id",insertable = false,updatable = false)
    private Integer orderId;

    @Column(name = "shoe_id",insertable = false,updatable = false)
    private Integer shoesId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "price")
    private Integer price;

    @JoinColumn(name = "order_id",insertable = true,updatable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    Orders orders;

    @JoinColumn(name = "shoe_id",insertable = true,updatable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    Shoes shoes;

    public Cart() {

    }

    public Cart(Integer orderId, Integer shoesId, Integer quantity, Integer price) {
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
