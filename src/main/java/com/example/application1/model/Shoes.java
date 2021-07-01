package com.example.application1.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shoes")
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "shoe_name")
    private String name;

    @Column(name = "shoe_form")
    private String form;

    @Column(name = "shoe_material")
    private String material;

    @Column(name = "shoe_heels")
    private Integer heels;

    @Column(name = "shoe_weight")
    private Integer weight;

    @Column(name = "shoe_price")
    private Integer price;

    @Column(name = "shoe_brand")
    private String brand;

    @Column(name = "shoe_size")
    private Integer size;

    @Column(name = "shoe_desc")
    private String desc;

    @Column(name = "shoe_color")
    private String color;

    @Column(name = "shoe_createDate")
    private Date createDate;

    @Column(name = "shoe_updateDate")
    private Date updateDate;

    @Column(name = "customer_id",insertable = false,updatable = false)
    private Integer customer_id;

    @JoinColumn(name = "customer_id",insertable = true,updatable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    Customers customer;

    public Shoes() {

    }

    public Shoes(String name, String form, String material, Integer heels, Integer weight, Integer price, String brand, Integer size, String desc, String color, Date createDate, Date updateDate) {
        this.name = name;
        this.form = form;
        this.material = material;
        this.heels = heels;
        this.weight = weight;
        this.price = price;
        this.brand = brand;
        this.size = size;
        this.desc = desc;
        this.color = color;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getHeels() {
        return heels;
    }

    public void setHeels(Integer heels) {
        this.heels = heels;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Shoes [name:" + name + ", form:" + form + ", material:" + material + ", heels:" + heels + ", weight:" + weight
                + ", price:" + price + ", brand:" + brand + ", size:" + size + ", desc:" + desc + ", color:" + color
                + ", create date:" + createDate + ", update date:" + updateDate + "]";
    }
}


