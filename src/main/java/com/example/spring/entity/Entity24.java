package com.example.spring.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_table24")
public class Entity24 {
    @EmbeddedId
    private Entity24Id id;

    private String email;
    private String password;
    private Integer age;

}
