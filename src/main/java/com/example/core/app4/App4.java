package com.example.core.app4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App4 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App4.class, args);
        Controller1 b1 = context.getBean(Controller1.class);
        Service1 b2 = context.getBean(Service1.class);
        b1.method1();
        b2.action1();

        b1.method2(); // Null Point Exception @Autowired 써서 안나옴
    }
}


@Component
class Controller1 {
    @Autowired // DI
    Service1 service;

    public void method2() {
        System.out.println("3️⃣서비스 메소드 실행");
        service.action1();
    }

    public void method1() {
        System.out.println("1️⃣Controller1 method1");
    }
}

@Component
class Service1 {
    public void action1() {
        System.out.println("2️⃣Service1 method1");
    }
}
