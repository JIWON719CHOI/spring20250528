package com.example.core.app7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App7 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App7.class, args);
        Bean2 bean = context.getBean(Bean2.class);
        // 실행 잘 도록 Bean2 에 setter 만들고
        // annotaion들 붙이기

        bean.action();
    }
}