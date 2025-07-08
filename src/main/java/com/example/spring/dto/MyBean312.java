package com.example.spring.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MyBean312 {
    private Double score;
    private String className;
    private String location;
    private MultipartFile[] uploads;
}