package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name = "my_table22", schema = "jpa")
public class Entity22 {
    @Id
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "address", length = 20)
    private String address;

    @Column(name = "country", length = 20)
    private String country;

}