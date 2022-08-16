package com.project.onlineShop.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @Column
    private int quantity;

    @Column
    private int price;

    @Column(unique = true)
    private String image;

    public Products(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    public int getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}
}
