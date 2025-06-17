package com.example.spring.controller;

import com.example.spring.service.Service3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
@RequestMapping("main21")
public class Controller21 {

    private final Service3 service3;

    @GetMapping("sub1")
    public String sub1() {
        service3.action1();

        return "/main21/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        service3.action2();
        return "/main21/sub2";
    }

    @GetMapping("sub3")
    public String sub3() {
        service3.action3();
        return "/main21/sub3";
    }

    // /main21/sub4?country=mexico
    // /main21/sub4?city=berlin
    @GetMapping("sub4")
    public String sub4(String country, String city) {
        service3.action4(country);
        service3.action5(city);
        return "/main21/sub4";
    }

    // /main21/sub6?start=1900-01-01&end=1989-12-31
    @GetMapping("sub6")
    public String sub6(LocalDate start, LocalDate end) {
        service3.action6(start, end);
        return "/main21/sub6";
    }

    // /main21/sub7?keyword=an
    @GetMapping("sub7")
    public String sub7(String keyword) {
        service3.action7(keyword);
        return "/main21/sub7";
    }

    // /main21/sub8?country=
    @GetMapping("sub8")
    public String sub8(String country) {
        service3.action8(country);
        return "/main21/sub8";
    }

    // /main21/sub9?city=london
    @GetMapping("sub9")
    public String sub9(String city) {
        service3.action9(city);
        return "/main21/sub9";
    }

    // /main21/sub10?name=en
    @GetMapping("sub10")
    public String sub10(String name) {
        service3.action10(name);
        return "/main21/sub10";
    }

    // /main21/sub11?start=1900-01-01&end=1999-12-31
    @GetMapping("sub11")
    public String sub11(LocalDate start, LocalDate end) {
        service3.action11(start, end);
        return "/main21/sub11";
    }

    @GetMapping("sub12")
    public String sub12(String city) {
        service3.action12(city);
        return "/main21/sub12";
    }

    //    /main21/sub13?cid=1
//    /main21/sub13?sid=2&price=50
//    /main21/sub13?p1=10&p2=100&keyword=choco
//    /main21/sub13?cids=1&cids=2
    @GetMapping("sub13")
    public String sub13(
            @RequestParam(required = false) Integer cid,
            @RequestParam(required = false) Integer sid,
            @RequestParam(required = false) Integer p1,
            @RequestParam(required = false) Integer p2,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) List<Integer> cids,
            @RequestParam(required = false) String keyword
    ) {
        service3.action13(cid, sid, p1, p2, price, cids, keyword);
        return "/main21/sub13";
    }

    @GetMapping("sub14")
    public String sub14(Integer id) {
        service3.action14(id);
        return "/main21/sub14";
    }

    @GetMapping("sub15")
    public String sub15(Integer id) {
        service3.action15(id);
        return "/main21/sub15";
    }

    // http://localhost:8080/main21/sub16?countries=usa&keyword=ad
    @GetMapping("sub16")
    public String sub16(@RequestParam(required = false) List<String> countries,
                        @RequestParam(required = false) String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            keyword = "%" + keyword + "%"; // 와일드카드 추가
        }
        service3.action16(countries, keyword);
        return "/main21/sub16";
    }

}
