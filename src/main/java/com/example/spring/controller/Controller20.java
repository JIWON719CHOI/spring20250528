package com.example.spring.controller;

import com.example.spring.entity.Entity13;
import com.example.spring.entity.Entity14;
import com.example.spring.service.Service1;
import com.example.spring.service.Service2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("main20")
@RequiredArgsConstructor
public class Controller20 {
    private final Service2 service2;
    private final Service1 service1;

    @GetMapping("sub0")
    public String sub0(Model model) {
        String result = service2.process0();
        return "/main20/sub0";
    }

    @GetMapping("sub1")
    public String sub1(Model model) {
        service2.process1();
        return "/main20/sub1";
    }

    @GetMapping("sub2")
    public String sub2(Model model) {
        service2.process2();
        return "/main20/sub2";
    }

    ///    jpa 사용
//      1. Entity : table과 1대1 매칭되는 클래스, 이 클래스로 만든 각 객체는 table의 각 행과 매치됨
//                  @Entity, @Table(클래스와 - 테이블 매핑)
//                  @Column(클래스필드와 - 테이블컬럼 매핑)
//                  @Id(클래스필드 - 테이블PK)

//      2. Repository
    @GetMapping("sub3")
    public String sub3(Model model) {
        service2.process3();
        return "/main20/sub3";
    }

    @GetMapping("sub4")
    public String sub4(Model model) {
        service2.process4();
        return "/main20/sub4";
    }

    @GetMapping("sub5")
    public String sub5(Model model) {
        service2.process5();
        return "/main20/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) {
        service2.process6();
        return "/main20/sub6";
    }

    @GetMapping("sub8")
    public String sub8(Model model) {
        service2.process8();
        return "/main20/sub8";
    }

    @GetMapping("sub10")
    public String sub10(Model model) {
        // Spring Data JPA
        // Entity : 테이블과 매핑되는 클래스 (객체)
        // Repository : Entity 를 이용한 CRUD 메소드 제공 (클래스/interface)
        // SELECT : find..... , get..... 어쩌구로 시작하는 메소드
        // UPDATE : save
        // DELETE : delete.....
        // INSERT : save

        // JpaRepository<T, ID> 인터페이스를 상속해서 만들면 됨
        // 타입파라미터 T : crud 대상 테이블의 매핑되는 Entity
        // 타입파라미터 ID : Entity의 PK(Primary Key) 자료형

        // Spring 은 -> Repository 인터페이스에 있는 메소드를 활용해서
        //              연결, statement, ResultSet 처리하는 구현 코드를 생성

        service2.process10();


        return "/main20/sub10";
    }

    @GetMapping("sub12")
    public String sub12(Model model) {
        service2.progress12();
        return "/main20/sub12";
    }

    // /main20/sub13?address=Shibuya&price=99&inserted=2025-06-16T15:56:30
    @GetMapping("sub13")
    public String sub13(String address, Integer price, LocalDateTime inserted) {
        service2.progress13(address, price, inserted);
        return "/main20/sub13";
    }

    @GetMapping("sub14")
    public String sub14(Integer id, Model model) {
        Entity14 data = service2.progress14(id);
        model.addAttribute("data", data);
        System.out.println(data);
        return "/main20/sub14";
    }

    @GetMapping("sub15")
    public String sub15(String name, Double score, String city) {
        Entity14 data = service2.progress15(name, score, city);
        return "/main20/sub15";
    }

    // /main20/sub16?id=2&score=12.34
    @GetMapping("sub16")
    public String sub16(Integer id, Double score) {
        service2.progress16(id, score);
        return "/main20/sub16";
    }

    //    /main20/sub17?id=1&address=Shinzuku
    @GetMapping("sub17")
    public String sub17(Integer id, String address) {
        service2.progress17(id, address);
        return "/main20/sub17";
    }

    // /main20/sub18?id=1
    @GetMapping("sub18")
    public String sub18(Integer id) {
        service2.progress18(id);
        return "/main20/sub18";
    }
}
