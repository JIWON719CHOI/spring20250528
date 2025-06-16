package com.example.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service /// 서비스 역할을 하는 녀석은 이걸 붙인다 서비스 안에 @Component 가 있음
public class Service1 {
    public String action1() {
        System.out.println("crud 작업. business logic 실행");
        return "결과값";
    }
}
