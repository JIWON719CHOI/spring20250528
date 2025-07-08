package com.example.spring.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/main28")
@CrossOrigin(origins = "http://localhost:5173")
public class Controller28 {

    @GetMapping("/sub1")
    public Map<String, Object> sub1() {
        System.out.println("▶ Controller01.sub1");
        System.out.println();
        // JSON 응답을 원한다면 Map 이나 DTO를 반환
        return Map.of("message", "sub1 호출 OK");
    }

    @PostMapping("/sub2")
    public String sub2() {
        System.out.println("▶ sub2 호출");
        System.out.println();
        return "sub2 OK";
    }

    @GetMapping("/sub4")
    public String sub4() {
        System.out.println("▶ sub4 호출");
        System.out.println();
        return "sub4 OK";
    }

    @PostMapping("/sub5")
    public String sub5(@RequestBody Map<String, Object> body) {
        System.out.println("▶ sub5 호출, 받은 body = " + body);

        String name = (String) body.get("name");
        // 안전한 숫자 변환
        int age = body.get("age") instanceof Number
                ? ((Number) body.get("age")).intValue()
                : 0;

        System.out.printf("▶ 이름=%s, 나이=%d%n", name, age);
        System.out.println();
        return "sub5 OK";
    }

    @GetMapping("sub8")
    public String sub8(String name, Integer age) {
        System.out.println("▶ name = " + name);
        System.out.println("▶ age = " + age);
        System.out.println();
        return "sub8 OK";
    }

    @GetMapping("sub10")
    public String sub10(String address, Double score) {
        System.out.println("▶ address = " + address);
        System.out.println("▶ score = " + score);
        System.out.println();
        return "sub10 OK";
    }

    @GetMapping("sub11")
    public String sub11(String address, Double score) {
        System.out.println("▶ address = " + address);
        System.out.println("▶ score = " + score);
        System.out.println();
        return "sub11 OK";
    }

    @GetMapping("sub13")
    public String sub13(String name, Integer age, String address) {
        System.out.println("▶ name = " + name);
        System.out.println("▶ age = " + age);
        System.out.println("▶ address = " + address);
        System.out.println();
        return "sub13 OK";
    }

    @GetMapping("/sub15")
    public String sub15(String name, Integer age, String country) {
        System.out.println("▶ name = " + name);
        System.out.println("▶ age = " + age);
        System.out.println("▶ country = " + country);
        System.out.println();
        return "sub15 OK";
    }

    @GetMapping({"sub17", "sub18", "sub19", "sub20"})
    public String sub17(String name, Integer age, String city) {
        System.out.println("▶ name = " + name);
        System.out.println("▶ age = " + age);
        System.out.println("▶ city = " + city);
        System.out.println();
        return "sub17 OK";
    }
}
