package com.example.spring.controller;

import com.example.spring.service.Service4;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("main22")
public class Controller22 {

    private final Service4 service4;

    // /main22/sub1?=10
    @GetMapping("sub1")
    public String sub1() {
        service4.action1();
        return "main22/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        service4.action2();
        return "main22/sub2";
    }

    @GetMapping("sub3")
    public String sub3() {
        service4.action3();
        return "main22/sub3";
    }

    @GetMapping("sub4")
    public String sub4() {
        service4.action4();
        return "main22/sub4";
    }

    @GetMapping("sub5")
    public String sub5() {
        service4.action5();
        return "main22/sub5";
    }

    @GetMapping("sub6")
    public String sub6(@RequestParam(defaultValue = "1") Integer page) {
        service4.action6(page);
        return "main22/sub6";
    }

    // 가격순(asc) 한페이지에 10개씩 상품 보여주기
    // 각페이지 출력할 때마다 다음페이지 있는지 여부 출력
    // 총페이지 수, 총 레코드 수 출력
    @GetMapping("sub7")
    public String sub7(@RequestParam(defaultValue = "1") Integer page) {
        service4.action7(page);
        return "main22/sub7";
    }
}
