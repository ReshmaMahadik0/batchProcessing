package com.example.BatchProcessing_app.entity;

<<<<<<< HEAD
import java.math.BigDecimal;

public class Product {

    private int productId;
    private String title;
    private String description;
    private BigDecimal price;
    private String discount;
    private BigDecimal discountedPrice;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
=======

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;


@Entity
public class Product {

    @Id
    private Long productId;

    private String title;
    private String description;
    private String price;
    private String discount;

    @Transient
    private String discountedPrice;

    // ✅ REQUIRED getters & setters

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
>>>>>>> d1bfe7fbb84a2a4c7db5d1203736662fda11ddde
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

<<<<<<< HEAD
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
=======
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
>>>>>>> d1bfe7fbb84a2a4c7db5d1203736662fda11ddde
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
