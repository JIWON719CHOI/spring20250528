package com.example.spring.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.spring.entity.Entity37}
 */
@Value
@Setter
@NoArgsConstructor(force = true)
public class Entity37Dto implements Serializable {
    String email;
    String info;
    LocalDateTime insertedAt;
}