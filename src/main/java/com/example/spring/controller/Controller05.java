package com.example.spring.controller;

import com.example.spring.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main5")
public class Controller05 {
    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("name", "son");

        // attribute 가 javaBeans(dto)
        MyBean051 m = new MyBean051();
        m.setAge(20);
        m.setAddress("seoul");
        m.setName("trump");

        model.addAttribute("obj", m);


        // forward to /templates/main5/sub1.html
        return "main5/sub1";
    }

    // 연습: 아래 코드를 보고 나머지 코드들(dto, html)을 완성하세요.
    @RequestMapping("sub2")
    public String sub2(Model model) {
        MyBean052 obj = new MyBean052();
        obj.setHome("ny");
        obj.setScore(98.76);
        obj.setHeight(180.5);
        obj.setNickName("tiger");

        model.addAttribute("attr", obj);

        return "main5/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {

        MyBean053 o = new MyBean053();
        o.setStudentNumber(99);
        o.setInfo("hello");
        o.setMarried(true);
        o.setWeight(99.88);

        model.addAttribute("val", o);

        return "main5/sub3";
    }

    // model attribute type 이 Map
    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("attr",
                Map.of("name", "Gojo",
                        "age", "28",
                        "address", "Tokyo",
                        "1 my info", "뭔 데 이 게"));
        return "main5/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {
        model.addAttribute("values", Map.of(
                "home", "Kyoto",
                "address", "Tokyo",
                "birth", "1989-12-07",
                "score", 99.99
        ));
        return "main5/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        model.addAttribute("car", Map.of(
                "model", "sm7",
                "company", "Samsung",
                "price", 454.4878,
                "used", "2025-05-29",
                "pre user", "뭐 무 뫄 솨 롸 좌 촤"
        ));
        return "main5/sub6";
    }

    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("list", new String[]{"gojo", "geto", "fushiguro", "kugisaki", "itadori", "nanami"});
        return "main5/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        model.addAttribute("jujutsu", new String[]{"GOJO", "GETO", "NANAMI", "FUSHIGURO", "KUGISAKI", "ITADORI"});
        return "main5/sub8";
    }

    @RequestMapping("sub9")
    public String sub9(Model model) {
        model.addAttribute("list", List.of("GOJO", "GETO", "NANAMI", "FUSHIGURO", "KUGISAKI", "ITADORI"));
        return "main5/sub9";
    }

    @RequestMapping("sub10")
    public String sub10(Model model) {
        MyBean054 j = new MyBean054("GOJO", 28, List.of("1234", "5678", "0987"));

        model.addAttribute("jujutsu", j);

        return "main5/sub10";
    }

    @RequestMapping("sub11")
    public String sub11(Model model) {
        MyBean055 k = new MyBean055(1207, String.valueOf(List.of("Gojo", "Satoru")), String.valueOf(List.of("Jujutsu", "Sorcerer")));

        model.addAttribute("jujutsu", k);
        return "main5/sub11";
    }

    @RequestMapping("sub12")
    public String sub12(Model model) {

        model.addAttribute("people", List.of(
                new MyBean056("tesla", 66, true),
                new MyBean056("apple", 77, false),
                new MyBean056("uber", 55, true)));

        return "main5/sub12";
    }

    @RequestMapping("sub13")
    public String sub13(Model model) {
        List<MyBean057> list = List.of(
                new MyBean057("Gojo", "1989-12-07", 0),
                new MyBean057("Geto", "1990-02-05", 1),
                new MyBean057("Ieiri", "1988-08-08", 2)
        );

        model.addAttribute("sorcerers", list); // 이름 부여!
        return "main5/sub13";
    }
}