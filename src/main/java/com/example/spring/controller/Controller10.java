package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main10")
public class Controller10 {
    @RequestMapping("sub1")
    public String sub1() {

        return "main10/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(String name, String city) {
        System.out.println("name = " + name);
        System.out.println("city = " + city);

        return "main10/sub1";
    }

    // get 요청 처리
    @RequestMapping(value = "sub3", method = RequestMethod.GET)
    public String sub3(String keyword) {
        System.out.println("keyword = " + keyword);
        System.out.println("Controller10.sub3");

        return "main10/sub3";
    }

    // post 요청 처리
    @RequestMapping(value = "sub3", method = RequestMethod.POST)
    public String sub4(String address) {
        System.out.println("address = " + address);
        System.out.println("Controller10.sub4");

        return "main10/sub3";
    }

//    @RequestMapping(value = "sub4", method = RequestMethod.GET)
    @GetMapping("sub4")
    public String sub5(String hi) {
        System.out.println("hi = " + hi);
        System.out.println("Controller10.sub5");
        return "main10/sub3";
    }

//    @RequestMapping(value = "sub4", method = RequestMethod.POST)
    @PostMapping("sub4")
    public String sub6(String bye) {
        System.out.println("bye = " + bye);
        System.out.println("Controller10.sub6");
        return "main10/sub3";
    }


}