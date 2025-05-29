package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model; // import 할때 Spring (초록아이콘) 하셈


@Controller
@RequestMapping("main4")
public class Controller04 {
    @RequestMapping("sub1")
    @ResponseBody
    public String sub1() {
        // 1.요청 분석/가공
        // 2.요청 처리(business logic)

        // 3.결과(html) 응답

        String htmlCode = """
                <!DOCTYPE html>
                <html>
                <body>
                    <h1>서버가 응답한 html 코드 🎉 </h1>
                    <p>이렇게 html을 작성하는 것은 너무 고통스럽다</p>
                </body>
                </html>
                """;
        return htmlCode;
    }

    @RequestMapping("sub2")
    @ResponseBody
    public String sub2(String keyword) {
        String weather = switch (keyword) {
            case "서울" -> "날씨 맑음";
            case "울릉도" -> "바람 많이 붐";
            default -> "알 수 없음";
        };

        String htmlCode = """
                <!DOCTYPE html>
                <html>
                <body>
                    <h1>검색한 지역의 날씨</h1>
                    <h3>""" + weather + """
                    </h3>
                </body>
                </html>
                
                """;
        return htmlCode;
    }

    @RequestMapping("sub3")
    public String sub3() {

        // 3. html 코드 응답

        // thymeleaf html 파일 위치
        // src/main/resources/templates/main4/sub3.html

        // view 로 forward 함
        return "main4/sub3";
    }

    // 연습:
    // /main4/sub4 로 요청 올 때
    // 아래 html이 최종 응답 되도록 request handler method를 작성해보세요.

    // src/main/resources/templates/main4/sub4.html

    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("userName", "돼지");
        return "main4/sub4";

    }

    @RequestMapping("sub5")
    public String sub5(Model model) {
        // 1.요청 분석/가공
        // 2.요청 처리(business logic)

        // 3. 결과를 Model에 담기
        model.addAttribute("name1", "결과 값1");
        model.addAttribute("name2", "또 다른 결과");

        // 4. view로 forwarding
        return "main4/sub5";
    }


    // 연습:
    // /main4/sub6 으로 요청 오면
    // templates/main4/sub6.html 이 응답 되도록
    // request handler method 작성

    @RequestMapping("sub6")
    public String sub6(Model model) {
        model.addAttribute("name", "GOJO");
        model.addAttribute("address", "Kyoto");
        model.addAttribute("email", "jujutsu");
        return "main4/sub6";
    }

    // 연습: 적절한 html 코드 작성
    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("age", 28);
        model.addAttribute("score", 97.54);
        model.addAttribute("school", "Jujutsu High");
        model.addAttribute("city", "Tokyo");
        return "main4/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        return "main4/sub8";
    }



}