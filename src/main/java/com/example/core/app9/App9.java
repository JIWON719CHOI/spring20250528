package com.example.core.app9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App9 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App9.class, args);
        Comp2 bean = context.getBean(Comp2.class);
        // 문제 없이 실행되게 Comp2에 생성자 만들고
        // annotation 들 적용하기
        bean.action1();
    }

}

@Component
class Comp1 {
    public void test() {
        System.out.println("Comp1.test");
    }
}
@Component
class Comp2 {
    Comp1 comp1;

//    @Autowired 생성자가 하나라면 생략 가능
    public Comp2(Comp1 comp1) {
        this.comp1 = comp1;
    }
    public void action1() {
        comp1.test();
    }
}