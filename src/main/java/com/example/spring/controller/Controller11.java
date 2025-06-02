package com.example.spring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("main11")
public class Controller11 {

    @GetMapping("sub1")
    public String sub1() {
        System.out.println("Controller11.sub1");
        return "main11/sub1";
    }


    // HttpSession : session 객체의 타입
    @PostMapping("sub1")
    public String sub2(String[] item, HttpSession session) {
        System.out.println("Controller11.sub2");
        System.out.println("Arrays.toString(item) = " + Arrays.toString(item));

        // getAttribute: session 에서 attribute 꺼내기
        var map = (Map<String, Integer>) session.getAttribute("cart");

        if (map == null) {
            // setAttribute : session 에 attribute 넣기
            map = new HashMap<>();
            session.setAttribute("cart", map);
        }

        if (item != null && item.length > 0) {
            for (String i : item) {
                if (map.containsKey(i)) {
                    Integer count = map.get(i);
                    map.put(i, count + 1);
                } else {
                    map.put(i, 1);
                }
            }
        }

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        return "main11/sub1";
    }

    @GetMapping("sub2")
    public String sub3() {

        return "main11/sub2";
    }

    @PostMapping("sub2")
    public String sub4(HttpSession session, Model model) {
        var number = (Integer) session.getAttribute("number");
        if (number == null) {
            number = 1;
        } else {
            number = number + 1;
        }
        session.setAttribute("number", number);
        model.addAttribute("value", number);

        return "main11/sub2";
    }

    @GetMapping("sub3")
    public String sub5(HttpSession session, Model model) {

        double random = Math.random();
        System.out.println("random = " + random);
        session.setAttribute("randomValue", random);
        model.addAttribute("value", random);

        session.setAttribute("myValue",
                Map.of("name", "길동", "address", "서울", "age", 98));
        // 연습 : 길동, 서울, 98 을 sub3.html에서 출력하기

        return "main11/sub3";
    }
}