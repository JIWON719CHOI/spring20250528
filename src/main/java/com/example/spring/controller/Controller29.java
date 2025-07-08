package com.example.spring.controller;

import com.example.spring.dto.MyBean291;
import com.example.spring.dto.MyBean292;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/main29")
@CrossOrigin(origins = "http://localhost:5173")
public class Controller29 {
    @PostMapping("/sub1")
    public String sub1() {
        System.out.println("Controller29.sub1");
        System.out.println();
        return "sub1 OK!";
    }

    @PostMapping("/sub2")
    public String sub2() {
        System.out.println("Controller29.sub2");
        System.out.println();
        return "sub2 OK!";
    }

    @PostMapping("/sub4")
    public String sub4(@RequestBody Map<String, Object> map) {
//        @RequestBody : JSON 을 해당 타입(Map)으로 역직렬화(디코딩, 파싱) 해주는 어노테이션
        System.out.println("Controller29.sub4");
        System.out.println("map = " + map);
        System.out.println();
        return "sub4 OK!";
    }

    @PostMapping("/sub5")
    public String sub5(@RequestBody Map<String, Object> map) {
        System.out.println("Controller29.sub5");
        System.out.println("map = " + map);
        System.out.println();
        return "sub5 OK!";
    }

    @PostMapping("/sub6")
    public String sub6(@RequestBody Map<String, Object> map) {
        for (String key : map.keySet()) {
            Object val = map.get(key);
            String type = (val == null) ? "null" : val.getClass().getSimpleName();
            System.out.printf("▶ %s = %s (%s)%n", key, val, type);

            // 자세한 타입 분기 확인
            if (val instanceof String str) {
                System.out.println("  - 문자열: " + str.toUpperCase());
            } else if (val instanceof Integer i) {
                System.out.println("  - 정수 + 10: " + (i + 10));
            } else if (val instanceof Double d) {
                System.out.println("  - 실수 * 2: " + (d * 2));
            } else if (val instanceof Boolean b) {
                System.out.println("  - 반대 값: " + !b);
            } else if (val instanceof List<?> list) {
                System.out.println("  - 리스트 크기: " + list.size());
            } else if (val instanceof Map<?, ?> innerMap) {
                System.out.println("  - 맵의 키: " + innerMap.keySet());
            } else if (val == null) {
                System.out.println("  - 값이 null 입니다.");
            } else {
                System.out.println("  - 기타 타입 처리 필요: " + val.getClass().getName());
            }

            System.out.println(); // 줄 바꿈
        }

        return "sub6 OK!";
    }

    @PostMapping("/sub8")
    public String sub8(@RequestBody Map<String, Object> map) {
        Object address = map.get("address");
        Object date = map.get("date");
        Object fruits = map.get("fruits");
        System.out.println(address.getClass().getSimpleName());
        System.out.println(date.getClass().getSimpleName());
        System.out.println(fruits.getClass().getSimpleName());
        System.out.println("address = " + address);
        System.out.println("date = " + date);
        System.out.println("fruits = " + fruits);
        System.out.println();
        return "sub8 OK!";
    }

    @PostMapping("/sub9")
    public String sub9(@RequestBody Map<String, Object> map) {
        Object name = map.get("name");
        Object teams = map.get("teams");
        Object person = map.get("person"); // object -> Map 으로 parsing

        System.out.println(person.getClass().getSimpleName());
        System.out.println(person);
        System.out.println();
        return "sub9 OK!";
    }

    @PostMapping("/sub11")
    public String sub11(@RequestBody List<Object> data) {
        System.out.println(data);
        System.out.println();
        return "sub11 OK!";
    }

    @PostMapping("sub12")
    public String sub12(@RequestBody List<Map<String, Object>> data) {
        for (Map<String, Object> map : data) {
            System.out.println(map);
        }
        return "sub12 OK!";
    }

    @PostMapping("sub13")
    public String sub13(@RequestBody MyBean291 dto) {
        System.out.println(dto.getNickName());
        System.out.println(dto.getAge());
        System.out.println(dto.getMarried());
        System.out.println(dto.getAddress());
        System.out.println(dto.getTeam());

        return "sub13 OK!";
    }

    @PostMapping("sub14")
    public String sub14(@RequestBody MyBean292 dto) {
        System.out.println(dto.getPerson());
        System.out.println(dto.getCity());
        System.out.println(dto.getScore());
        System.out.println(dto.getChecked());
        System.out.println(dto.getNotes());
        System.out.println();
        return "sub14 OK!";

    }

}
