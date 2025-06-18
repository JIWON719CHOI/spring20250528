package com.example.spring.service;

import com.example.spring.entity.Entity27;
import com.example.spring.entity.Entity28;
import com.example.spring.entity.Entity29;
import com.example.spring.entity.Entity30;
import com.example.spring.repo.Entity27Repository;
import com.example.spring.repo.Entity28Repository;
import com.example.spring.repo.Entity29Repository;
import com.example.spring.repo.Entity30Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service                 // 이 클래스는 서비스 역할 (실제 로직을 처리)
@RequiredArgsConstructor // final로 선언된 리포지토리를 생성자로 자동 주입
@Transactional           // 이 클래스의 모든 메서드는 트랜잭션 안에서 실행됨
public class Service7 {

    private final Entity27Repository entity27Repository;
    private final Entity28Repository entity28Repository;
    private final Entity29Repository entity29Repository;
    private final Entity30Repository entity30Repository;

    public void action1() {
        Entity27 c1 = new Entity27();
        Entity27 c2 = new Entity27();
        Entity27 c3 = new Entity27();

        c1.setCategoryName("DRINK");
        c1.setInfo("SUGAR");

        c2.setCategoryName("ELECTRONIC");
        c2.setInfo("THUNDER");

        c3.setCategoryName("CLEANER");
        c3.setInfo("CLEAN");

        entity27Repository.save(c1);
        entity27Repository.save(c2);
        entity27Repository.save(c3);
    }

    public void action2() {
        Entity28 p1 = new Entity28();
        Entity28 p2 = new Entity28();
        Entity28 p3 = new Entity28();
        Entity28 p4 = new Entity28();
        Entity28 p5 = new Entity28();
        Entity28 p6 = new Entity28();

        p1.setPrice(500);
        p2.setPrice(300);
        p3.setPrice(200);
        p4.setPrice(100);
        p5.setPrice(50);
        p6.setPrice(10);

        p1.setProductName("청소기");
        p2.setProductName("컴퓨터");
        p3.setProductName("콜라");
        p4.setProductName("사이다");
        p5.setProductName("물티슈");
        p6.setProductName("모니터");

        p1.setUnit("1대");
        p2.setUnit("1대");
        p3.setUnit("1캔");
        p4.setUnit("1캔");
        p5.setUnit("1장");
        p6.setUnit("1대");

        Entity27 c1 = entity27Repository.findById(1).get();
        Entity27 c2 = entity27Repository.findById(2).get();
        Entity27 c3 = entity27Repository.findById(3).get();

        p1.setCategory(c3);
        p2.setCategory(c2);
        p3.setCategory(c1);
        p4.setCategory(c1);
        p5.setCategory(c3);
        p6.setCategory(c2);

        entity28Repository.save(p1);
        entity28Repository.save(p2);
        entity28Repository.save(p3);
        entity28Repository.save(p4);
        entity28Repository.save(p5);
        entity28Repository.save(p6);
    }

    public void action3(Integer id) {
        Entity27 entity27 = entity27Repository.findById(id).get();
        System.out.println("entity27 = " + entity27);
    }

    public void action4(Integer id) {
        Entity28 entity28 = entity28Repository.findById(id).get();
        System.out.println("entity28 = " + entity28);
    }

    public void action5() {
        Entity29 e1 = new Entity29();
        Entity29 e2 = new Entity29();
        Entity29 e3 = new Entity29();

        e1.setFirstName("Gojo");
        e1.setLastName("Satoru");
        e1.setBirthDate(LocalDate.parse("1989-12-07"));

        e2.setFirstName("Geto");
        e2.setLastName("Suguru");
        e2.setBirthDate(LocalDate.parse("1990-02-05"));

        e3.setFirstName("Ieiri");
        e3.setLastName("Shoko");
        e3.setBirthDate(LocalDate.parse("1988-07-07"));

        entity29Repository.save(e1);
        entity29Repository.save(e2);
        entity29Repository.save(e3);
    }

    public void action6() {
        Entity30 o1 = new Entity30();
        Entity30 o2 = new Entity30();
        Entity30 o3 = new Entity30();
        Entity30 o4 = new Entity30();
        Entity30 o5 = new Entity30();
        Entity30 o6 = new Entity30();

        o1.setOrderDate(LocalDate.parse("2025-06-18"));
        o2.setOrderDate(LocalDate.parse("2025-06-19"));
        o3.setOrderDate(LocalDate.parse("2025-06-20"));
        o4.setOrderDate(LocalDate.parse("2025-06-21"));
        o5.setOrderDate(LocalDate.parse("2025-06-22"));
        o6.setOrderDate(LocalDate.parse("2025-06-23"));

        o1.setInfo("Food");
        o2.setInfo("Cleaner");
        o3.setInfo("Electronic");
        o4.setInfo("어쩌구");
        o5.setInfo("저쩌구");
        o6.setInfo("어쩌구저쩌구");

        Entity29 e1 = entity29Repository.findById(1).get();
        Entity29 e2 = entity29Repository.findById(2).get();
        Entity29 e3 = entity29Repository.findById(3).get();

        o1.setEmployee(e3);
        o2.setEmployee(e1);
        o3.setEmployee(e2);
        o4.setEmployee(e3);
        o5.setEmployee(e1);
        o6.setEmployee(e2);

        entity30Repository.saveAll(List.of(o1, o2, o3, o4, o5, o6));
    }

    public void action7(Integer id) {
        Entity29 e = entity29Repository.findById(id).get();
        System.out.println("e = " + e);
    }

    public void action8(Integer id) {
        Entity30 e = entity30Repository.findById(id).get();
        System.out.println("e = " + e);
    }

    public void action9(Integer id) {
        Entity30 o = entity30Repository.findById(id).get();

        System.out.println("o.getOrderDate() = " + o.getOrderDate());
        System.out.println("o.getInfo() = " + o.getInfo());

        // 직원정보
        System.out.println("o.getEmployee().getLastName() = " + o.getEmployee().getLastName());
    }
}
