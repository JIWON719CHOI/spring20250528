package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "my_table36")
@Getter
@Setter
@ToString
public class Entity36 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate registeredAt;
    private String enabled;
    private String money;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Entity34 student;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Entity35 lecture;
}