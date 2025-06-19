package com.example.spring.repo;

import com.example.spring.dto.ProductInfo;
import com.example.spring.entity.Entity39;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity39Repository extends JpaRepository<Entity39, Integer> {
    @Query(value = """
            SELECT p.id, p.name product_name, p.price, c.name category_name
            FROM my_table39 p JOIN my_table40 c
                                ON p.category_id = c.id
            """, nativeQuery = true)
    List<ProductInfo> query1();
}