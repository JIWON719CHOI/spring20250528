package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("main9")
public class Controller09 {

    @RequestMapping("sub1")
    public String sub1() {

        return "main9/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(String name, Integer age, String address) {

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("address = " + address);

        return "main9/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(String email,
                       Boolean married,
                       String team,
                       String city) {
        System.out.println("email = " + email);
        System.out.println("married = " + married);
        System.out.println("team = " + team);
        System.out.println("city = " + city);
        return "main9/sub3";

    }

    @RequestMapping("sub4")
    public String sub4() {
        return "main9/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(String keyword, String email) {
        System.out.println("keyword = " + keyword);
        System.out.println("email = " + email);
        return "main9/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(String address, Integer age, String city) {
        System.out.println("address = " + address);
        System.out.println("age = " + age);
        System.out.println("city = " + city);
        return "main9/sub6";

    }

    @RequestMapping("sub13")
    public String sub13(String city,
                        Integer age,
                        Double score,
                        String[] fruits,
                        Boolean accepted) {

        System.out.println("city = " + city);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
        System.out.println("Arrays.toString(fruits) = " + Arrays.toString(fruits));
        System.out.println("accepted = " + accepted);
        return "main9/sub13";
    }
}