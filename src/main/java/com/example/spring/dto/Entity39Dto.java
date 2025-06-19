package com.example.spring.dto;

import com.example.spring.entity.Entity39;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Entity39}
 */
@Data
public class Entity39Dto implements Serializable {
    Integer id;
    String name;
    Integer price;
    String categoryName;
}