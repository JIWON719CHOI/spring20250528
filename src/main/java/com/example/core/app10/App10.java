package com.example.core.app10;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App10 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App10.class, args);
        Controller1 bean = context.getBean(Controller1.class);
        bean.action();

        Controller2 bean1 = context.getBean(Controller2.class);
        bean1.go();
    }
}

@Component
// final 필드를 파라미터로 받는 생성자 만들어 줌
@RequiredArgsConstructor
class Controller2 {
    final Service2 service2;

    public void go() {
        service2.action();
    }
}

@Component
class Service2 {
    public void action() {
        System.out.println("Service2.action");
    }
}

@Component
class Controller1 {
    final Service1 service1;

    public Controller1(Service1 service1) {
        this.service1 = service1;
    }

    public void action() {
        service1.method();
    }
}

@Component
class Service1 {

    public void method() {
        System.out.println("Service1.method");
    }
}