package com.example.spring.dto;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/main30")
@CrossOrigin(origins = "http://localhost:5173")
public class Controller30 {
    @PutMapping("/sub1")
    public String sub1() {
        System.out.println("Controller30.sub1");
        System.out.println();
        return "sub1 PUT!";
    }

    // RequestMapping(method = RequestMethod.DELETE, path = "sub2")
    @DeleteMapping("/sub2")
    public String sub2() {
        System.out.println("Controller30.sub2");
        System.out.println();
        return "sub2 DELETE!";
    }

    @PutMapping("sub5")
    public String sub5(@RequestBody MyBean291 dto) {
        System.out.println(dto);
        return "sub5 PUT!";
    }

    @PostMapping("sub7")
    public String sub7(String name, Integer age, MultipartFile myFile) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("myFile = " + myFile.getOriginalFilename());
        System.out.println("myFile = " + myFile.getSize());
        return "sub7 POST!";
    }

}
