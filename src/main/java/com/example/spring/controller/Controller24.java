package com.example.spring.controller;

import com.example.spring.service.Service6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("main24")
public class Controller24 {

    private final Service6 service6;

    @GetMapping("sub1")
    public String sub1(String name, String address) {
        service6.action1(name, address);
        return "main24/sub1";
    }

    @GetMapping("sub2")
    public String sub2(String name, String address, String country) {
        service6.action2(name, address, country);
        return "main24/sub2";
    }
}
