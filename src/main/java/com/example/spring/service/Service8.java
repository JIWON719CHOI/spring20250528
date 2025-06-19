package com.example.spring.service;

import com.example.spring.dto.Entity36Dto;
import com.example.spring.dto.Entity39Dto;
import com.example.spring.dto.OrderInfo;
import com.example.spring.dto.ProductInfo;
import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity35;
import com.example.spring.entity.Entity36;
import com.example.spring.entity.Entity39;
import com.example.spring.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class Service8 {

    private final Entity34Repository entity34Repository;
    private final Entity35Repository entity35Repository;
    private final Entity36Repository entity36Repository;
    private final Entity39Repository entity39Repository;
    private final Entity41Repository entity41Repository;

    public void action1() {
        // 학생정보 입력
        Entity34 s1 = new Entity34();
        Entity34 s2 = new Entity34();
        Entity34 s3 = new Entity34();
        s1.setName("lee");
        s2.setName("wang");
        s3.setName("zhang");
        entity34Repository.save(s1);
        entity34Repository.save(s2);
        entity34Repository.save(s3);

        // 강의정보 입력
        Entity35 l1 = new Entity35();
        Entity35 l2 = new Entity35();
        Entity35 l3 = new Entity35();
        l1.setLectureTitle("java");
        l2.setLectureTitle("python");
        l3.setLectureTitle("react");
        entity35Repository.save(l1);
        entity35Repository.save(l2);
        entity35Repository.save(l3);

        // 수강정보 입력
        // 학생1->강의1,2
        // 학생2->강의2,3
        // 학생3->강의1,3

        Entity36 i1 = new Entity36();
        Entity36 i2 = new Entity36();
        Entity36 i3 = new Entity36();
        Entity36 i4 = new Entity36();
        Entity36 i5 = new Entity36();
        Entity36 i6 = new Entity36();

        i1.setRegisteredAt(LocalDate.now());
        i2.setRegisteredAt(LocalDate.now());
        i3.setRegisteredAt(LocalDate.now());
        i4.setRegisteredAt(LocalDate.now());
        i5.setRegisteredAt(LocalDate.now());
        i6.setRegisteredAt(LocalDate.now());

        // 학생1->강의1,2
        i1.setStudent(s1);
        i2.setStudent(s1);
        i1.setLecture(l1);
        i2.setLecture(l2);

        // 학생2->강의2,3
        i3.setStudent(s2);
        i4.setStudent(s2);
        i3.setLecture(l2);
        i4.setLecture(l3);

        // 학생3->강의1,3
        i5.setStudent(s3);
        i6.setStudent(s3);
        i5.setLecture(l1);
        i6.setLecture(l3);

        entity36Repository.saveAll(List.of(i1, i2, i3, i4, i5, i6));
    }

    public void action2() {
        // 두명의 학생 (2개 record)
        Entity34 s1 = new Entity34();
        Entity34 s2 = new Entity34();
        s1.setName("kim");
        s2.setName("son");
        entity34Repository.save(s1);
        entity34Repository.save(s2);

        // 두개의 강의 (2개 lecture)
        Entity35 l1 = new Entity35();
        Entity35 l2 = new Entity35();
        l1.setLectureTitle("javascript");
        l2.setLectureTitle("ai");
        entity35Repository.save(l1);
        entity35Repository.save(l2);

        // 각학생이 하나의 강의 수강 (2개의 수강정보)
        Entity36 i1 = new Entity36();
        Entity36 i2 = new Entity36();

        i1.setRegisteredAt(LocalDate.now());
        i2.setRegisteredAt(LocalDate.now());

        i1.setStudent(s1);
        i2.setStudent(s2);
        i1.setLecture(l1);
        i2.setLecture(l2);

        entity36Repository.saveAll(List.of(i1, i2));
    }

    public void action3() {
        // 4번학생이 수강한 강의 지우기
        entity36Repository.deleteByStudentId(4);
    }

    public void action4() {
        // 5번학생 지우기
        entity34Repository.deleteById(5);
    }

    public void action5() {
        // 5번학생의 수강정보를 먼저 지워야함
        entity36Repository.deleteByStudentId(5);
        // 5번학생 지우기
        entity34Repository.deleteById(5);
    }

    public void action6() {
        // 연습
        // 3번 강의 지우기
        entity36Repository.deleteByLectureId(3);
        entity35Repository.deleteById(3);
    }

    public void action7() {
        Entity36 l1 = entity36Repository.findById(1).get();
        System.out.println(l1.getRegisteredAt());

        Entity34 s1 = l1.getStudent();

        // LAZY일 경우 이 때 select 쿼리 실행
        String name = s1.getName();
        System.out.println("name = " + name);
    }

    public Entity36 action8() {
        Entity36 l1 = entity36Repository.findById(1).get();

        return l1;

    }

    public Entity36Dto action9() {
        Entity36 l1 = entity36Repository.findById(1).get();

        Entity36Dto d1 = new Entity36Dto();
        d1.setRegisteredAt(l1.getRegisteredAt());
        d1.setStudentName(l1.getStudent().getName());

        // entity 리턴하면 안됨
        // ->dto로 값 옮겨 담고 리턴하기
        return d1;
    }

    public List<Entity39Dto> action10() {
        // t39(product), t40(category)
        // 상품번호,상품명,가격,카테고리이름
        List<Entity39> list = entity39Repository.findAll();

        List<Entity39Dto> result = new ArrayList<>();
        for (Entity39 entity39 : list) {
            Entity39Dto d = new Entity39Dto();
            d.setId(entity39.getId());
            d.setName(entity39.getName());
            d.setPrice(entity39.getPrice());
            d.setCategoryName(entity39.getCategory().getName());
            result.add(d);
        }
        return result;
    }

    public List<ProductInfo> action11() {
        // t39(product), t40(category)
        // 상품번호,상품명,가격,카테고리이름
        /*
        SELECT p.id, p.name product_name, p.price, c.name category_name
        FROM t39 p JOIN t40 c p.category_id = c.id
         */
        List<ProductInfo> result = entity39Repository.query1();
        return result;
    }

    public List<OrderInfo> action12() {
        return entity41Repository.query1();
    }
}