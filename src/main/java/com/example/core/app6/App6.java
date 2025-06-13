
package com.example.core.app6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App6 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App6.class, args);
        Comp1 bean = context.getBean(Comp1.class);
        bean.some(); // NullPointerException

    }
}

@Component
class Comp1 {

    Comp2 comp2;

    // setter 사용한 Dependency Injection (DI)
    @Autowired
    public void setComp2(Comp2 comp2) {
        this.comp2 = comp2;
    }

    public void some() {
        comp2.crud();
    }
}

@Component
class Comp2 {
    public void crud() {
        System.out.println("Comp2.crud");
    }
}
