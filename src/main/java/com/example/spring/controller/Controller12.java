package com.example.spring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("main12")
public class Controller12 {
    @GetMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("address", "Tokyo");

        // view로 forward
        return "main12/sub1";
    }

    @GetMapping("sub2")
    // redirect 시나리오에서 model에 값을 전달해주는 역할
    public String sub2(Model model, RedirectAttributes rttr) {
        System.out.println("Controller12.sub2");

        model.addAttribute("country", "Japan");
        rttr.addFlashAttribute("city", "Tokyo"); // 한번만 쓰는..

        // redirection : 다른 곳으로 요청하라는 응답
        return "redirect:/main12/sub3";
    }

    @GetMapping("sub3")
    public String sub3(Model model) {
        System.out.println("Controller12.sub3");
        model.addAttribute("email", "yahoo");
        return "/main12/sub3";
    }

    // 연습
    // get /main12/sub4 로 요청오면
    //    : /main12/sub5 로 redirection
    //      RedirectAttributes 에 name : donald를 넣고


    @GetMapping("sub4")
    public String sub4(Model model, RedirectAttributes rttr) {
        System.out.println("Controller12.sub4");
        rttr.addFlashAttribute("name", "Gojo");
        return "redirect:/main12/sub5";
    }

    // get /main12/sub5 에서
    //    : main12/sub5.html 로 forward

    //    view 에서 name Model attribute를 꺼내서 출력하기
    @GetMapping("sub5")
    public String sub5(Model model) {
        System.out.println("Controller12.sub5");
        return "/main12/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model, RedirectAttributes rttr) {
        System.out.println("Controller12.sub6");

        // 다음 요청 Model에 옮겨담음
        rttr.addFlashAttribute("nickName", "Satoru");

        // query string 에 붙음 ?address=Tokyo
        rttr.addAttribute("address", "Tokyo");
        return "redirect:/main12/sub7";
    }

    @GetMapping("sub7")
    public String sub7(Model model) {
        System.out.println("Controller12.sub7");
        return "/main12/sub7";
    }

    @GetMapping("sub8")
    public String sub8(Model model, RedirectAttributes rttr) {
        rttr.addFlashAttribute("item", "Car");
        rttr.addAttribute("company", "Tesla");
        return "redirect:/main12/sub9";
    }

    @GetMapping("sub9")
    public String sub9(Model model) {
        return "/main12/sub9";
    }

    // main
    @GetMapping("sub10")
    public String sub10(Model model) {
        return "/main12/sub10";
    }

    // login page
    @GetMapping("sub11")
    public String sub11(Model model) {
        return "/main12/sub11";
    }

    // login 처리
    @PostMapping("sub11")
    public String sub11Process(String id, RedirectAttributes rttr, HttpSession session) {
        System.out.println(id + "LONGIN");

        session.setAttribute("userId", id);
        rttr.addFlashAttribute("message", id + " LOGIN SUCCESS");
        return "redirect:/main12/sub10";
    }

    @RequestMapping("sub11/logout")
    public String sub11Logout(HttpSession session, RedirectAttributes rttr) {
//        session.removeAttribute("userId"); // session attribute만 지우는 코드.
        session.invalidate(); // session 객체를 아예 날려버리는 코드.
        rttr.addFlashAttribute("message", "LOGOUT!");
        return "redirect:/main12/sub10";
    }
}
