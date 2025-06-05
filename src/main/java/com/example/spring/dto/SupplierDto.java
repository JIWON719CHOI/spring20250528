package com.example.spring.dto;

import lombok.Data;

@Data
public class SupplierDto {
    private Integer id;
    private String name;
    private String contact;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String phone;

}