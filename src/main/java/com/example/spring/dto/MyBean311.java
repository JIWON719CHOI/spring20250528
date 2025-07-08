package com.example.spring.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MyBean311 {
    private Integer id;
    private String userName;
    private String address;
    private MultipartFile[] uploadFiles;
}
