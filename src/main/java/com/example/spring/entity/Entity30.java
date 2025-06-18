package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name = "my_table30", schema = "jpa")
public class Entity30 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // "이 필드의 값을 자동으로 DB 에서 생성해줘" 특히 기본 키(@Id) 필드에 사용
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "info", length = 20)
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Entity29 employee;

}