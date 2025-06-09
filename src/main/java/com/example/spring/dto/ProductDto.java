package com.example.spring.dto; // 패키지 경로 (Data Transfer Object를 모아놓는 디렉토리)

import lombok.Data; // Lombok 라이브러리의 @Data 어노테이션을 사용

@Data // Lombok이 getter, setter, toString, equals, hashCode를 자동 생성해줌
public class ProductDto {
    private Integer id;        // 상품 ID (ProductID)
    private String name;       // 상품 이름 (ProductName)
    private Integer supplier;  // 공급자 ID (SupplierID)
    private Integer category;  // 카테고리 ID (CategoryID)
    private String unit;       // 단위 (Unit)
    private Double price;      // 가격 (Price)
}
