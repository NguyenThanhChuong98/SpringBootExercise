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
@Table(name = "shoes")
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "form")
    private String form;

    @Column(name = "material")
    private String material;

    @Column(name = "heels")
    private Integer heels;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "price")
    private Integer price;

    @Column(name = "brand")
    private String brand;

    @Column(name = "size")
    private Integer size;

    @Column(name = "desc")
    private String desc;

    @Column(name = "color")
    private String color;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "createdDate")
    private Date createDate;

    @Column(name = "updatedDate")
    private Date updateDate;


    public Shoes() {

    }

    public Shoes(String name, String form, String material, Integer heels, Integer weight, Integer price, String brand, Integer size, String desc, String color,Integer quantity, Date createDate, Date updateDate) {
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
        this.quantity = quantity;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    @Override
    public String toString() {
        return "Shoes [name:" + name + ", form:" + form + ", material:" + material + ", heels:" + heels + ", weight:" + weight
                + ", price:" + price + ", brand:" + brand + ", size:" + size + ", desc:" + desc + ", color:" + color
                + ", quantity: " + quantity + ", create date:" + createDate + ", update date:" + updateDate + "]";
    }
}


