package com.example.spring.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode // 재정의 해야 쓸 수 있음
//@NoArgsConstructor // 파라미터 없는 생성자
@AllArgsConstructor // 모든 필드를 받는 생성자
@RequiredArgsConstructor // final 필드를 초기화 하는 생성자
public class MyBean034 {
    private String home;
    private final Integer age;

}
