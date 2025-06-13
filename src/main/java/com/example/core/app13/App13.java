package com.example.core.app13;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App13 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App13.class, args);
        Controller1 bean = context.getBean(Controller1.class);
        // 문제 없이 실행되게
        // Service1에 @Component 붙이지 않기
        // AppConfiguration  클래스와 그 안의 메소드
        // 적절한 annotation들 적용하기
        bean.get();
    }
}

@Configuration
class AppConfiguration {
    @Bean // 이 spring bean의 이름은 메소드 이름으로 결정
    public Service1 makeBean(){
        return new Service1();
    }
    @Bean
    public Service2 makeBean2(){
        return new Service2();
    }
}

@Component
@RequiredArgsConstructor
class Controller1{
    final Service1 service1;
    final Service2 service2;

    public void get() {
        service1.crud();
        service2.crud();
    }
}

class Service1{
    public void crud() {
        System.out.println("Service1.crud");
    }
}

class Service2{
    public void crud() {
        System.out.println("Service2.crud");
    }
}
