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
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "require_date")
    private Date requireDate;

    @Column(name = "shipped_date")
    private Date shippedDate;

    @Column(name = "order_status")
    private boolean orderStatus;

    @Column(name = "comments")
    private String comments;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;

    @JoinColumn(name  = "customer_id",insertable = true,updatable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    Customer customers;

    public Order() {

    }

    public Order(Date orderDate, Date requireDate, Date shippedDate, boolean orderStatus, String comments, Integer customerId) {
        this.orderDate = orderDate;
        this.requireDate = requireDate;
        this.shippedDate = shippedDate;
        this.orderStatus = orderStatus;
        this.comments = comments;
        this.customerId = customerId;
    }


}


