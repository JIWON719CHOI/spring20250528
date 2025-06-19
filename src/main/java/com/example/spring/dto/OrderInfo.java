package com.example.spring.dto;

import lombok.ToString;

import java.time.LocalDate;

public interface OrderInfo {
//    SELECT o.order_date, p.name product_name, p.price, o.quantity, c.name category_name

    LocalDate getOrderDate();

    String getProductName();

    Integer getPrice();

    Integer getQuantity();

    String getCategoryName();
}