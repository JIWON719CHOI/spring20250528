package com.example.spring.controller;

import com.example.spring.dto.UserDto;
import jakarta.servlet.http.*; // 세션이나 쿠키 같은 웹 요청 관련 클래스들을 사용하기 위해 가져옵니다.
import lombok.extern.slf4j.Slf4j; // Slf4j는 **로깅(log 출력)**을 도와주는 lombok의 기능입니다.
import org.springframework.stereotype.Controller; // 이 클래스를 Spring Controller로 등록하기 위한 애너테이션입니다.
import org.springframework.ui.Model; // 뷰에 데이터를 넘겨줄 때 사용하는 Model 객체입니다.
import org.springframework.web.bind.annotation.*; // @GetMapping, @PostMapping 등을 사용하려면 이걸 import 해야 해요.

import java.util.HashMap;
import java.util.Map;

@Controller // 스프링이 웹 요청을 처리하는 클래스로 등록합니다.
@Slf4j // log.info() 같은 로그를 쓸 수 있게 해줍니다.
@RequestMapping("/main")
public class MainController {

    // 💡 사용자 이름 별 로그인 횟수를 기억할 Map
    private final Map<String, Integer> loginCountMap = new HashMap<>();
    // key: 사용자 이름 (String), value: 로그인 횟수 (Integer) 예) loginCountMap.put("철수", 3);

    // 1️⃣로그인 폼 보여주기 : /main/login 으로 GET 요청이 오면 loginForm.html 뷰를 보여줍니다.
    @GetMapping("/login")
    public String showLoginForm() {
        return "/main/loginForm"; // loginForm.html 로 이동
    }

    // 2️⃣로그인 처리 : /main/login 으로 POST 요청이 오면 이 메서드가 실행됩니다.
    @PostMapping("/login")
    public String login(
            @ModelAttribute UserDto userDto, // @ModelAttribute는 HTML 폼에서 전송된 데이터를 UserDto 객체에 자동으로 담아줘요.
            HttpSession session // HttpSession은 사용자의 세션 정보를 저장하는 객체예요.
    ) { // 입력된 이름 가져오기
        String name = userDto.getName();

        // 세션에 사용자 이름 저장 : 이 이름을 브라우저 세션에 저장해서, 다음 화면에서도 사용할 수 있어요.
        session.setAttribute("userName", name);

        // 💡 이름별로 로그인 횟수 증가 : 예) 철수가 3번째 로그인하면 → loginCountMap["철수"] = 3
        loginCountMap.put(name, loginCountMap.getOrDefault(name, 0) + 1);

        return "redirect:/main/home"; // 로그인 후 /main/home 으로 리다이렉트합니다. (주소창 URL도 바뀜)
    }

    // 3️⃣홈 화면 보여주기 : /main/home 에 GET 요청이 오면 이 메서드가 실행됩니다. 세션에서 사용자 이름을 가져오고, 로그인 횟수를 계산해서 모델에 담습니다.
    @GetMapping("/home")
    public String home(
            HttpSession session,
            Model model
    ) {
        String name = (String) session.getAttribute("userName"); // 세션에 저장된 사용자 이름을 가져옵니다.

        if (name == null) return "redirect:/main/login"; // 만약 세션에 이름이 없다면 → 로그인 페이지로 다시 보냅니다.

        // 💡 해당 이름으로 저장된 로그인 횟수 가져오기
        int count = loginCountMap.getOrDefault(name, 0);

        // 뷰(html)로 데이터를 보냅니다.
        model.addAttribute("name", name);
        model.addAttribute("count", count);

        return "/main/home";
    }
}
