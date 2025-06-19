package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "my_table40", schema = "jpa")
public class Entity40 {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "description", length = 50)
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Entity39> myTable39s = new LinkedHashSet<>();

}