package com.example.spring.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MyBean321 {
    private String name;
    private Integer id;
    private List<String> fruits;
    private Map<String, Object> address;
}