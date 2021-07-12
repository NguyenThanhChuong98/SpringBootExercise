package com.example.application1.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
    Customers customers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    List<Cart> order_cart;

    public Orders() {

    }

    public Orders(Date orderDate, Date requireDate, Date shippedDate, boolean orderStatus, String comments, Integer customerId) {
        this.orderDate = orderDate;
        this.requireDate = requireDate;
        this.shippedDate = shippedDate;
        this.orderStatus = orderStatus;
        this.comments = comments;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getRequireDate() {
        return requireDate;
    }

    public void setRequireDate(Date requireDate) {
        this.requireDate = requireDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}


