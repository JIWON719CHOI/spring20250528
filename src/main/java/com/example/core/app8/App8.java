package com.example.core.app8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App8 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App8.class, args);
        Bean2 b = context.getBean(Bean2.class);
        b.action(); //
    }
}

@Component
class Bean1 {
    public void print() {
        System.out.println("Bean1.print");
    }
}

@Component
class Bean2 {
    Bean1 bean1;

    // 생성자 DI
    @Autowired
    public Bean2(Bean1 bean1) {
        this.bean1 = bean1;
    }

    public void action() {
        bean1.print();
    }
}