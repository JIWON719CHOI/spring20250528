package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("main0")
public class Controller00 {

    @RequestMapping("sub0")
    public String sub0() {
        return "main0/sub0";
    }

    @GetMapping("sub1")
    public String sub1() {
        return "main0/sub1";
    }

    @PostMapping("sub1")
    public String handleSub1Post(
            @RequestParam Map<String, String> params,
            @RequestParam(name = "upload", required = false) MultipartFile file,
            Model model
    ) throws IOException {
        model.addAttribute("formData", params);

        if (file != null && !file.isEmpty()) {
            // 저장할 경로 (임시로 /tmp 에 저장)
            String filename = file.getOriginalFilename();
            String filepath = System.getProperty("java.io.tmpdir") + "/" + filename;
            file.transferTo(new java.io.File(filepath));

            // 결과에 경로 추가
            model.addAttribute("filename", filename);
            model.addAttribute("filePath", "/files/" + filename); // 가상경로
        } else {
            model.addAttribute("filename", "없음");
            model.addAttribute("filePath", null);
        }

        return "main0/result";
    }
}
