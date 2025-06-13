package com.example.core.app5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App5 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App5.class, args);
        Controller1 b1 = context.getBean(Controller1.class);
        Service1 b2 = context.getBean(Service1.class);
        b1.go(); // 문제 없이 실행되도록 어노테이션 완성
        b2.act();
    }
}

@Component
class Service1 {
    public void act() {
        System.out.println("🔔헤헤");
    }
}

