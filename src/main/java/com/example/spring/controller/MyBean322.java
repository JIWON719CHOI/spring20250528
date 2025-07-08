package com.example.spring.controller;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MyBean322 {
    private Integer id;
    private String title;
    private Map<String, Object> category;
    private List<String> orders;
    private Double price;
}