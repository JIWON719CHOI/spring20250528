package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor // 모든 생성자를 초기화
public class MyBean054 {
    private String name;
    private int age;
    private List<String> phoneNumbers;
}
