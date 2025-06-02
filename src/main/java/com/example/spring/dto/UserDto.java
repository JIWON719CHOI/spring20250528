package com.example.spring.dto;

import lombok.Data;

@Data // @Data는 자동으로 getter, setter, toString, equals, hashCode 같은 메서드를 만들어 줍니다.
public class UserDto {
    private String name; // 사용자가 입력한 이름
    //dto는 Data Transfer Object의 약자로, 데이터를 전달하는 용도의 클래스입니다.
}