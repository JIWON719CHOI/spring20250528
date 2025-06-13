package com.example.core.app11;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App11 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App11.class, args);
        Bean1 bean = context.getBean(Bean1.class);
        // 잘 되도록 코드 작성(lombok의 어노테이션 활용)

        bean.some();

    }
}

@Component
class Bean1 {
    final Bean2 bean2;

    public Bean1(Bean2 bean2) {
        this.bean2 = bean2;
    }

    public void some() {
        bean2.crud();
    }
}

@Component
class Bean2 {
    public void crud() {
        System.out.println("Bean2.crud");
    }
}