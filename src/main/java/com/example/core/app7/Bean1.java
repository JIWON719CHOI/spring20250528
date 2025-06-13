package com.example.core.app7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bean1 {
    public void go() {
        System.out.println("Bean1.go");
    }
}