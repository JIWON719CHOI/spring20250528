package com.example.spring.dto;

import lombok.Data;

// 자주 사용하는...
// Getter, Setter, toString, equalsAndHashCode, RequiredArgsConstructor
// 위에 5개 합친게 @Data


@Data
public class MyBean035 {
    private String address;
    private Double salary;
}
