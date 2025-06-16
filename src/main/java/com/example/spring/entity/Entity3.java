package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_table3")
@Getter
@Setter
@ToString
public class Entity3 {
    @Id // pk 역할
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column 은 생략 가능

    //    @Column(name = "email")
    private String email;

    //    @Column(name = "info")
    private String info;

    //    @Column(name = "nick")
    private String nick;

    private String country;

    // java 변수명 관습 lowerCamelCase
    @Column(name = "home_address") // 이름이 다르니 붙여야 함
    private String homeAddress;

    @Column(name = "work_address")
    private String workAddress;

}
