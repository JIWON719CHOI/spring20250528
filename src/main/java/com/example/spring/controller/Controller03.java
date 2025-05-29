package com.example.spring.controller;

import com.example.spring.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("main3") // 모든 메소드의 경로 앞 부분에 적용
public class Controller03 {

    // http://localhost:8080/main3/sub1

    @RequestMapping("sub1")
    public void sub1() {
        System.out.println("Controller03.sub1");
    }

    @RequestMapping("sub2")
    public void sub2() {
        System.out.println("Controller03.sub2");
    }

    // 연습:
    // /main3/sub3 요청 올 때 일하는 메소드 작성
    @RequestMapping("sub3")
    public void sub3() {
        System.out.println("Controller03.sub3");
    }

    // /main3/sub4?param1=val1&param2=val2
    @RequestMapping("sub4")
    public void sub4(@RequestParam("param1") String param1,
                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
    }

    // /main3/sub5?address=seoul&age=44&email=gmail&home=dokdo&city=ny&name=donald
    @RequestMapping("sub5")
    public void sub5(@RequestParam Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // request parameter 를 java beans (Data Transaction Object) 으로 받기
    // /main3/sub6?name=donald&address=la
    // /main3/sub6?name=trump
    // /main3/sub6?address=ny
    @RequestMapping("sub6")
    public void sub6(MyBean031 params) {
        System.out.println("params.getName() = " + params.getName());
        System.out.println("params.getAddress() = " + params.getAddress());
    }

    // 연습:
    // /main3/sub7?name=musk&company=tesla&home=texas
    // /main3/sub7?name=musk&home=texas
    // /main3/sub7?name=musk&home=texas&age=55
    // /main3/sub7?name=musk&home=texas
    // MyBean032 javaBean(dto)를 만들어서 request parameter 받아보기
    @RequestMapping("sub7")
    public void sub7(MyBean032 params) {
        System.out.println(params);
    }

    // /main3/sub8?nickName=trump&age=55&address=ny&score=98.99
    @RequestMapping("sub8")
    public void sub8(MyBean033 params) {
        System.out.println(params);
    }

    // /main3/sub9?address=seoul&salary=50.5
    @RequestMapping("sub9")
    public void sub9(MyBean035 params) {
        System.out.println(params);
    }

    // 연습:
    // /main3/sub10?age=44&email=gmail&married=true&salary=40.4&name=donald
    // 요청 파라미터 받는 MyBean036 클래스 만들고
    // request handler method 작성
    @RequestMapping("sub10")
    public void sub10(MyBean036 params) {
        System.out.println(params);
    }

    // /main3/sub11?name=donald&address=ny&pw=1234
    // /main3/sub11?name=donald&address=ny&password=5678

    // request parameter와 같은 이름의 setter 메소드를 사용
    @RequestMapping("sub11")
    public void sub11(MyBean037 params) {
        System.out.println(params);
    }

    // /main3/sub12?name=gojo&age=28&skill=jujutsu&skill=limitless&skill=sorcerer
    @RequestMapping("sub12")
    public void sub12(MyBean0310 params) {
        System.out.println(params);
    }

    // /main3/sub13?hobby=sweet&hobby=none&score=999.999&score=888.888
    // dto(MyBean0311)와 request handler method 만들기
    @RequestMapping("/sub13")
    public void sub13(MyBean0311 params) {
        System.out.println(params);
    }
}