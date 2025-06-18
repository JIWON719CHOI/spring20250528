package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name = "my_table23", schema = "jpa")
public class Entity23 {
    @EmbeddedId
    private Entity23Id id;

    @Column(name = "country", length = 30)
    private String country;

    @Column(name = "info", length = 30)
    private String info;

}