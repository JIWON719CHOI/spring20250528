package com.example.spring.controller;

import com.example.spring.service.Service1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller ///  이 안에 @Component 가 들어 있음. 그래서 커피콩 모양 있는 것.
@RequestMapping("main19")
@RequiredArgsConstructor
public class Controller19 {

    // Spring bean - Dependency Injection (field, setter, constructor)
    private final Service1 service1;


    @GetMapping("sub1")
    public String sub1(Model model) {
        // 1. 요청 받고 / 가공

        // 2. crud
        // 2.1 jdbc 연결
        // 2.2 statement 얻고
        // 2.3 쿼리 실행
        // 2.4 result set 처리

        /// 위 2번의 과정을 이제 service 에게 모두 맡길 수 있음
        String result = service1.action1();

        // 3. 모델에 결과 넣고
        model.addAttribute("data", result);
        // forward
        return "main19/sub1";
    }


}