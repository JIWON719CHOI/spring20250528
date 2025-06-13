package com.example.core.app1;

public class App1 {
    public static void main(String[] args) {
        // 업무 로직 실행
        Service1 service = new Service1();

        // 생성자 통해서 Dependency Injection
        Controller1 controller1 = new Controller1(service);

        // setter 통해서 Dependency Injection
        controller1.setService(service);

        controller1.method1();
    }
}

class Controller1 {

    // dependency(의존성, 의존객체)
    // field 통해서 Dependency Injection(DI)
    Service1 service = new Service1();

    public Controller1() {
    }

    public Controller1(Service1 service) {
        this.service = service;
    }

    public void setService(Service1 service) {
        this.service = service;
    }

    public void method1() {
        // 요청받고
        // CRUD
        service.create();
        // 모델에 값 넣고
        // VIEW forward
    }

    public void method2() {
        // 요청받고
        service.read();
        // 모델에 넣고
        // view forward

    }
}

class Service1 {
    public void create() {
        // 새 데이터 입력 코드
    }

    public void read() {
        // 기존 데이터 조회 코드
    }
}