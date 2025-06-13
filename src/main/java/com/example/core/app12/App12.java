package com.example.core.app12;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App12 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App12.class, args);
        Bean1 bean = context.getBean(Bean1.class);
        bean.some();
    }
}

// @Component 외에 Spring Bean을 만드는 방법
// @Configuration 클래스와 @Bean 메소드 조합
@Configuration
class AppConfiguration {
    @Bean
    public OtherClass makeBean() {
        return new OtherClass();
    }
}

// 내가 만든 거
@Component
@RequiredArgsConstructor
class Bean1 {
    final OtherClass otherClass;

    public void some() {
        otherClass.action();
    }
}

// 다른 사람이 만든 거 수정 불가
class OtherClass {
    public void action() {
        System.out.println("OtherClass.action");
    }
}
