package com.example.spring.dto;

import com.example.spring.entity.Entity38;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Entity38}
 */
@Value
public class Entity38Dto implements Serializable {
    Integer id;
    String title;
    String content;
    String authorEmail;
    LocalDateTime insertedAt;
}