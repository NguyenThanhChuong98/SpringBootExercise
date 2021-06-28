package com.example.application1.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "customer_account", unique = true)
    private String account;

    @Column(name = "customer_password")
    private String password;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "customer_phone", unique = true)
    private long phone;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_sex")
    private boolean sex;

    @Column(name = "customer_createdDate")
    private Date createdDate;

    @Column(name = "customer_updatedDate")
    private Date updatedDate;

    public Customer() {

    }


    public Customer(String account, String password, String name, Date dateOfBirth, long phone, String address, boolean sex, Date createdDate, Date updatedDate) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public long getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdateDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Customer [ account:" + account + ", password:" + password + ", name:" + name +
                ", date of birth:" + dateOfBirth + ", phone:" + phone + ", address:" + address +
                ", sex:" + sex + "create date:" + createdDate + ", update date:" + updatedDate + "]";
    }
}
