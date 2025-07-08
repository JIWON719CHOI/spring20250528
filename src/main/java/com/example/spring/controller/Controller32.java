package com.example.spring.controller;

import com.example.spring.dto.MyBean321;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/main32")
@CrossOrigin(origins = "http://localhost:5173")
public class Controller32 {
    @GetMapping("sub1")
    @ResponseBody // 리턴 값이 응답 데이터다. @RestController 를 쓰면 생략 가능
    public String sub1() {
        System.out.println("Controller32.sub1");

        try {
            Thread.sleep(5000); // 5초 멈추기
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // view 로 forward 가 아니라 client 에게 응답하는 값
        return "클라이언트로 전달할 값";
    }

    @GetMapping("sub2")
    @ResponseBody
    public String sub2() {
        return "🥸sub2";
    }

    @GetMapping("sub3")
    @ResponseBody
    public Map<String, Object> sub3() {

        return Map.of("name", "Gojo", "age", 28);
    }

    @GetMapping("sub5")
    @ResponseBody
    public Map<String, Object> sub5() {
        return Map.of("id", 55,
                "city", "london",
                "phone", Map.of("phone1", "9999", "phone2", "8888"));
    }

    @GetMapping("sub6")
    @ResponseBody
    public Map<String, Object> sub6() {
        return Map.of("id", 53,
                "name", "흥민",
                "address", List.of("서울", "런던", "파리"));
    }

    @GetMapping("sub7")
    @ResponseBody
    public MyBean321 sub7() {
        MyBean321 myBean321 = new MyBean321();
        myBean321.setId(912);
        myBean321.setName("차범근");
        myBean321.setFruits(List.of("apple", "lemon"));
        myBean321.setAddress(Map.of("city", "신촌", "country", "한국"));
        // json
        // {"id": 912, "name": "차범근",
        // "fruits": ["apple", "lemon"], "address": {"city":"신촌", "country":"한국"}}

        return myBean321;
    }

    // 연습 : react에 8번째 버튼 클릭시 dto의 모든 값을 출력 하는 코드 완
    @GetMapping("sub8")
    @ResponseBody
    public MyBean322 sub8() {
        MyBean322 myBean322 = new MyBean322();
        myBean322.setId(912);
        myBean322.setTitle("소년이");
        myBean322.setCategory(Map.of("author", "한강", "genre", "소설"));
        myBean322.setOrders(List.of("교보", "알라딘"));
        myBean322.setPrice(9000.00);

        return myBean322;
    }

    // ResponseEntity : 상태 코드(response status code) 를 설정해서 응답 가능한 객체
    @GetMapping("sub9")
    @ResponseBody
    public ResponseEntity sub9() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("sub10")
    @ResponseBody
    public ResponseEntity sub10() {
        return ResponseEntity.status(404).build();
    }

    @GetMapping("sub11")
    @ResponseBody
    public ResponseEntity sub11() {
        return ResponseEntity.status(500).build();
    }

    @GetMapping("sub12")
    @ResponseBody
    public ResponseEntity sub12() {
        // 200
        return ResponseEntity.ok().build();
    }

    @GetMapping("sub13")
    @ResponseBody
    public ResponseEntity sub14() {
        // 405
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("sub15")
    @ResponseBody
    public ResponseEntity sub15() {
        // 404
        return ResponseEntity.ok().build();
    }

    @GetMapping("sub16")
    @ResponseBody
    public ResponseEntity sub16() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("sub18")
    @ResponseBody
    public ResponseEntity sub18() {
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("sub19")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> sub19() {
        return ResponseEntity.ok().body(Map.of("name", "toji", "address", "tokyo"));
    }

    // 연습: react 21번째,22번째 버튼 클릭시 아래 응답 데이터가 콘솔에 출력하도록 코드 완성
    @GetMapping("sub21")
    @ResponseBody
    public ResponseEntity<List<String>> sub21() {
        return ResponseEntity.status(201).body(List.of("java", "css", "react"));
    }

    @GetMapping("sub22")
    @ResponseBody
    public ResponseEntity<List<String>> sub22() {
        return ResponseEntity.status(500).body(List.of("apple", "lemon", "mango"));
    }

    @GetMapping("sub23")
    @ResponseBody
    public ResponseEntity<List<String>> sub23() {
        if (Math.random() < (1.0 / 3)) {
            return ResponseEntity.status(400).build();
        } else if (Math.random() < (2.0 / 3)) {
            return ResponseEntity.status(500).build();
        } else {
            return ResponseEntity.status(200).build();
        }
    }


}
