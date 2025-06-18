package com.example.spring.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Entity24Id implements Serializable {
    private String name;
    private String address;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Entity24Id that = (Entity24Id) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        ///  전통 방식, 자동 생성
//        int result = Objects.hashCode(name);
//        result = 31 * result + Objects.hashCode(address);
//        return result;
        /// 간결 방식, 요즘 사용
        return Objects.hash(name, address);
    }
}
