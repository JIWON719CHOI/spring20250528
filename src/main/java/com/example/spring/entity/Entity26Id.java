package com.example.spring.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Entity26Id implements Serializable {
    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Entity26Id that = (Entity26Id) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
//        int result = Objects.hashCode(firstName);
//        result = 31 * result + Objects.hashCode(lastName);
//        return result;
        return Objects.hash(firstName, lastName);
    }
}
