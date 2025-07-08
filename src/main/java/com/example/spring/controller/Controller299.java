// ✅ Controller299.java (백엔드)
package com.example.spring.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/main299")
@CrossOrigin(origins = "http://localhost:5173") // Vite 기본 포트
public class Controller299 {

    @GetMapping("/item")
    public Map<String, Object> getItem(@RequestParam Integer id) {
        return Map.of("id", id, "name", "사과", "price", 1000);
    }

    @PostMapping("/item")
    public String postItem(@RequestBody Map<String, Object> body) {
        System.out.println("POST body: " + body);
        return "상품 등록 완료";
    }

    @PutMapping("/item/{id}")
    public String putItem(@PathVariable Integer id, @RequestBody Map<String, Object> body) {
        System.out.println("PUT id=" + id + ", body: " + body);
        return "상품 전체 수정 완료";
    }

    @PatchMapping("/item/{id}")
    public String patchItem(@PathVariable Integer id, @RequestBody Map<String, Object> body) {
        System.out.println("PATCH id=" + id + ", body: " + body);
        return "상품 부분 수정 완료";
    }

    @DeleteMapping("/item/{id}")
    public String deleteItem(@PathVariable Integer id) {
        System.out.println("DELETE id=" + id);
        return "상품 삭제 완료";
    }

    @RequestMapping(value = "/item", method = RequestMethod.HEAD)
    public ResponseEntity<Void> headItem() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "HeadTest");
        return ResponseEntity.ok().headers(headers).build();
    }

    @RequestMapping(value = "/item", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsItem() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "GET,POST,PUT,PATCH,DELETE,OPTIONS,HEAD");
        return ResponseEntity.ok().headers(headers).build();
    }

    @PostMapping("/form")
    public String formSubmit(@RequestParam String title, @RequestParam String price) {
        System.out.println("Form 수신 title=" + title + ", price=" + price);
        return "폼 제출 완료";
    }
}
