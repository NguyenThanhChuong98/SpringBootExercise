package com.example.application1.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shoes")
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "shoe_name")
    private String name;

    @Column(name = "shoe_form")
    private String form;

    @Column(name = "shoe_material")
    private String material;

    @Column(name = "shoe_heels")
    private long heels;

    @Column(name = "shoe_weight")
    private long weight;

    @Column(name = "shoe_price")
    private long price;

    @Column(name = "shoe_brand")
    private String brand;

    @Column(name = "shoe_size")
    private long size;

    @Column(name = "shoe_desc")
    private String desc;

    @Column(name = "shoe_color")
    private String color;

    @Column(name = "shoe_createDate")
    private Date createDate;

    @Column(name = "shoe_updateDate")
    private Date updateDate;

    public Shoes() {

    }

    public Shoes(String name, String form, String material, long heels, long weight, long price, String brand, long size, String desc, String color,Date createDate, Date updateDate) {
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getForm(){
        return form;
    }

    public void setForm(String form){
        this.form = form;
    }

    public String getMaterial(){
        return material;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public long getHeels() {
        return heels;
    }

    public void setHeels(long heels){
        this.heels = heels;
    }

    public long getWeight(){
        return weight;
    }

    public void setWeight(long weight){
        this.weight = weight;
    }

    public long getPrice(){
        return price;
    }

    public void setPrice(long price){
        this.price = price;
    }

    public String brand(){
        return brand;
    }

    public void setBrand(){
        this.brand = brand;
    }

    public long getSize(){
        return size;
    }

    public void setSize(long size){
        this.size = size;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(){
        this.desc = desc;
    }

    public String color(){
        return color;
    }

    public void setColor(){
        this.color = color;
    }

    public Date getCreateDate(){
        return createDate;
    }

    public Date getUpdateDate(){
        return updateDate;
    }

    public void setCreateDate(){
        this.updateDate = updateDate;
    }

    @Override
    public String toString(){
        return "Shoes [name:" + name + ", form:" + form + ", material:" + material + ", heels:" + heels + ", weight:" + weight
                + ", price:" + price + ", brand:" + brand + ", size:" + size + ", desc:" + desc + ", color:" + color
                + ", create date:" + createDate + ", update date:" + updateDate + "]";
    }
}


