package com.example.BatchProcessing_app.entity;

public class Product {

    private int product_id;

    private String title;

    private String description;

    private String price;

    private String discount;

    private String discountedPrice;


    public Product(int product_id, String title, String price, String description, String discount) {
        this.product_id = product_id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.discount = discount;
    }

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
