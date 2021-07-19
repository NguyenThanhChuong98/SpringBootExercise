package com.example.application1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "orders")
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

    @ManyToMany(mappedBy = "shoesOrder")
    private List<Shoes> orderShoes;

    @OneToMany
    @JoinColumn(name = "order_id")
    List<Customer_Order> orderCustomer;

    public Order() {

    }



    public Order(Date orderDate, Date requireDate, Date shippedDate, boolean orderStatus, String comments, Integer customerId) {
        this.orderDate = orderDate;
        this.requireDate = requireDate;
        this.shippedDate = shippedDate;
        this.orderStatus = orderStatus;
        this.comments = comments;
    }


}


