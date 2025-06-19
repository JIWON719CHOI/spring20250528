package com.example.spring.dto;

public interface ProductInfo {
    // SELECT p.id, p.name product_name, p.price, c.name category_name
    Integer getId();

    String getProductName();

    Integer getPrice();

    String getCategoryName();
}
