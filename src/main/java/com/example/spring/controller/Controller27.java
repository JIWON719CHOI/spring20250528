package com.example.spring.controller;

import com.example.spring.service.Service9;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("main27")
@RequiredArgsConstructor
public class Controller27 {

    private final Service9 service9;

    @GetMapping("sub1")
    public String sub1() {

        return "main27/sub1";
    }

    @PostMapping("sub1")
    public String post1(String username, MultipartFile upload) {
        service9.action1(username, upload);

        return "redirect:/main27/sub1";
    }

    @PostMapping("sub2")
    public String post2(String address,
                        @RequestParam(name = "uploadFile", required = false)
                        MultipartFile upload) {

        service9.action2(address, upload);

        return "redirect:/main27/sub1";
    }

    @PostMapping("sub3")
    public String post3(MultipartFile[] upload) {
        service9.action3(upload);

        return "redirect:/main27/sub1";
    }
}