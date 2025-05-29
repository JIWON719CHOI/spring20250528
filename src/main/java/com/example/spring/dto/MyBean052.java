package com.example.spring.dto;

import lombok.Data;

@Data
public class MyBean052 {
    private String home;
    private Double score;
    private Double height;
    private String nickName;

    public String getInformation(){
        return "My home is" + home + "and My scores" + score + "and I'm" + height +"tall.";
    }
}
