package com.example.spring.controller;

import com.example.spring.dto.MyBean311;
import com.example.spring.dto.MyBean312;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/main31")
@CrossOrigin(origins = "http://localhost:5173")
public class Controller31 {

    @PostMapping("sub1")
    public String sub1(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("myFiles[]") MultipartFile[] files) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        if (files != null) {
            for (MultipartFile file : files) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }

        return "sub1 Single-File";
    }

    @PostMapping("sub2")
    public String sub2(String address, Double score,
                       @RequestParam("yourFiles[]")
                       MultipartFile[] yourFiles) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        if (yourFiles != null) {
            for (MultipartFile file : yourFiles) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        System.out.println();

        return "sub2 Multiple_Files";
    }

    @PostMapping("sub3")
    public String sub3(String city, @RequestParam("uploadFiles[]") MultipartFile[] uploadFiles) {
        System.out.println("city = " + city);
        if (uploadFiles != null) {
            for (MultipartFile file : uploadFiles) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        System.out.println();
        return "sub3 Multiple_Files";
    }

    @PostMapping("sub4")
    public String sub4(MyBean311 dto) {
        System.out.println("dto.getId() = " + dto.getId());
        System.out.println("dto.getUserName() = " + dto.getUserName());
        System.out.println("dto.getAddress() = " + dto.getAddress());
        MultipartFile[] uploadFiles = dto.getUploadFiles();
        if (uploadFiles != null) {
            for (MultipartFile file : uploadFiles) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        System.out.println();
        return "sub4 Multiple_Files";
    }

    @PostMapping("sub5")
    public String sub5(MyBean312 dto) {
        System.out.println("dto.getScore() = " + dto.getScore());
        System.out.println("dto.getClassName() = " + dto.getClassName());
        System.out.println("dto.getLocation() = " + dto.getLocation());
        MultipartFile[] uploads = dto.getUploads();
        if (uploads != null) {
            for (MultipartFile file : uploads) {
                System.out.println("file = " + file.getOriginalFilename());
                System.out.println("file = " + file.getSize());
            }
        }
        System.out.println();
        return "sub5 Multiple_Files";
    }

    @GetMapping("sub6/{city}")
    public String sub6(@PathVariable("city") String city) {
        System.out.println("city = " + city);
        System.out.println("Controller31.sub6");
        return "sub6 PathVariable";
    }

    @GetMapping("sub7/{id}")
    public String sub6(@PathVariable("id") Integer id) {
        System.out.println("cid = " + id);
        System.out.println("Controller31.sub7");
        return "sub7 PathVariable";
    }

}
