package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name = "my_table28")
public class Entity28 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private Integer price;
    private String unit;

    // category_id ⭐⭐⭐
//    private Integer categoryId;
//    @OneToOne(cascade = CascadeType.ALL) 이건 뭥미?
//    @OneToMany 여기서는 이거 쓰면 안됨.
    @ManyToOne // pK를 갖고 있는 쪽이 one 이다.
    @JoinColumn(name = "category_id")
    private Entity27 category;

}
