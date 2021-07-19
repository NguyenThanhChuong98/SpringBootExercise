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
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "account", unique = true)
    private String account;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "phone", unique = true)
    private Integer phone;

    @Column(name = "address")
    private String address;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "createDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    List<Order> orders;

    public Customer() {

    }


    public Customer(String account, String password, String name, Date dateOfBirth, Integer phone, String address, Date createdDate, Date updatedDate) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Customer [ account:" + account + ", password:" + password + ", name:" + name +
                ", date of birth:" + dateOfBirth + ", phone:" + phone + ", address:" + address +
                ", sex:" + sex + "create date:" + createdDate + ", update date:" + updatedDate + "]";
    }

}
