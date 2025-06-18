package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "my_table20", schema = "jpa")
public class Entity20 {
    @Id
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "money")
    private Integer money;

}