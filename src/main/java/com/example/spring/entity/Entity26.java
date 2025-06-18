package com.example.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "my_table26")
public class Entity26 {

    @EmbeddedId
    private Entity26Id id;

    private String title;
    private String description;
    private String author;
}
