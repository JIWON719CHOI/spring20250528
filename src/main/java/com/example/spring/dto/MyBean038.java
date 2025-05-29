package com.example.spring.dto;

public class MyBean038 {
    // field = nickName, password
    // property = name(읽기, 쓰기), pw(읽기, 쓰기), description(읽기)
    private String nickName;
    private String password;

    public String getName() {
        return nickName;
    }

    public void setName(String name) {
        this.nickName = name;
    }

    public String getPw() {
        return password;
    }

    public void setPw(String pw) {
        this.password = pw;
    }
}
