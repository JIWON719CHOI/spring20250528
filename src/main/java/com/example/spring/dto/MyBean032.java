package com.example.spring.dto;

public class MyBean032 {
    private String name;
    private String company;
    private String home;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyBean032{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", home='" + home + '\'' +
                ", age=" + age +
                '}';
    }
}
