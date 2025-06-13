package com.example.core.app7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bean2 {
    Bean1 bean1;
    Bean3 bean3;

    @Autowired
    public void setBean1(Bean1 bean1) {
        this.bean1 = bean1;
    }
    @Autowired
    public void setBean3(Bean3 bean3) {
        this.bean3 = bean3;
    }
    public void action() {
        bean1.go();
        bean3.stop();
    }
}