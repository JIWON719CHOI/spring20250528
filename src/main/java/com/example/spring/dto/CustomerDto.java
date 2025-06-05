package com.example.spring.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Integer id;
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String contactName;
}
