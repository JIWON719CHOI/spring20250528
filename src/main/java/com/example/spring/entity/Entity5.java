package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "my_table5")
@Getter
@Setter
@ToString
public class Entity5 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    @Column(name = "hired_date")
    private LocalDate hiredDate;

    @Column(name = "inserted_at")
    private LocalDateTime insertedAt;

    private Double height;

    private Integer score;
}
