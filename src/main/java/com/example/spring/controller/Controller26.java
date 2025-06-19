package com.example.spring.controller;

import com.example.spring.service.Service8;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("main26")
public class Controller26 {

    private final Service8 service8;

    @RequestMapping("sub1")
    public String sub1() {

        service8.action1();

        return "main26/sub1";
    }

    @RequestMapping("sub2")
    public String sub2() {
        // 연습

        // 두명의 학생 (2개 record)
        // 두개의 강의 (2개 lecture)
        // 각학생이 하나의 강의 수강 (2개의 수강정보)
        service8.action2();
        return "main26/sub2";
    }

    @RequestMapping("sub3")
    public String sub3() {
        service8.action3();

        return "main26/sub3";
    }

    @RequestMapping("sub4")
    public String sub4() {
        service8.action4();

        return "main26/sub4";
    }

    @RequestMapping("sub5")
    public String sub5() {
        service8.action5();

        return "main26/sub5";
    }

    @RequestMapping("sub6")
    public String sub6() {
        service8.action6();
        return "main26/sub6";
    }
}