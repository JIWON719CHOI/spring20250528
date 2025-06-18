package com.example.spring.controller;

import com.example.spring.service.Service5;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("main23")
public class Controller23 {

    private final Service5 service5;

    @GetMapping("sub1")
    public String sub1(Integer page) {

        service5.action1(page);

        return "main23/sub1";
    }

    // sub2?country=mexico
    @GetMapping("sub2")
    public String sub2(String country) {
        service5.action2(country);
        return "main23/sub2";
    }

    @GetMapping("sub3")
    public String sub3(String country, @RequestParam(defaultValue = "1") Integer page) {
        service5.action3(country, page);
        return "main23/sub3";
    }

    @GetMapping("sub4")
    public String sub4(String keyword, @RequestParam(defaultValue = "1") Integer page) {
        service5.action4(keyword, page);
        return "main23/sub4";
    }

    // /sub6?country=mexico
    @GetMapping("sub6")
    public String sub6(String country) {
        service5.action6(country);
        return "main23/sub6";
    }

    // /main23/sub7?
    @GetMapping("sub7")
    public String sub7() {
        service5.action7();
        return "main23/sub7";
    }

    // /main23/sub8
    @GetMapping("sub8")
    public String sub8() {
        service5.action8();
        return "main23/sub8";
    }

    // /sub9?country=germany
    @GetMapping("sub9")
    public String sub9(String country) {
        service5.action9(country);
        return "main23/sub9";
    }

    @GetMapping("sub10")
    public String sub10(String country) {
        service5.action10(country);
        return "main23/sub10";
    }

    @GetMapping("sub11")
    public String sub11(String country) {
        service5.action11(country);
        return "main23/sub11";
    }


}
