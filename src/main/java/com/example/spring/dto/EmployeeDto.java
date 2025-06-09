package com.example.spring.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {
    private Integer id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String photo;
    private String notes;
}