package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "my_table4")
@Getter
@Setter
@ToString
public class Entity4 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double score;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "start_at")
    private LocalTime startAt;

    @Column(name = "created_at")
    private LocalDateTime createAt;
}
