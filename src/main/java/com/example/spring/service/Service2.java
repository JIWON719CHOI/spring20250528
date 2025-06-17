package com.example.spring.service;

import com.example.spring.entity.*;
import com.example.spring.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Service2 {

    private final Entity1Repository entity1Repository;
    private final Entity2Repository entity2Repository;
    private final Entity3Repository entity3Repository;
    private final Entity4Repository entity4Repository;
    private final Entity5Repository entity5Repository;
    private final Entity6Repository entity6Repository;
    private final Entity8Repository entity8Repository;
    private final Entity10Repository entity10Repository;
    private final Entity12Repository entity12Repository;
    private final Entity13Repository entity13Repository;
    private final Entity14Repository entity14Repository;


    public String process0() {
        System.out.println("Service2 process1");
        return "Hello World";
    }

    public void process1() {
        // business logic

        // spring data jpa 를 사용해서 crud :
        // 연결, statement, sql, result set 다 해줌
        Entity1 res = entity1Repository.findById(1).get();
        System.out.println(res.getId());
        System.out.println(res.getName());
        System.out.println(res.getAddress());
    }

    public void process2() {

        Entity2 data = entity2Repository.findById(2).get();
        System.out.println(data);

    }

    public void process3() {
        Entity3 data = entity3Repository.findById(1).get();
        System.out.println(data);
    }

    public void process4() {
        Entity4 data = entity4Repository.findById(1).get();
        System.out.println(data);
    }

    public void process5() {
        Entity5 data = entity5Repository.findById(1).get();
        System.out.println(data);
    }

    public void process6() {
        Entity6 data = entity6Repository.findById(1).get();
        System.out.println(data);
    }

    public void process8() {
        Optional<Entity8> data = entity8Repository.findById(1);
    }

    public void process10() {
        // findById : 키(id)로 하나의 record(row행) 를 조회함
        Optional<Entity10> data = entity10Repository.findById(1);
        System.out.println(data.isPresent()); // true
        System.out.println(data.isEmpty()); // false
    }

    public void progress12() {
        Optional<Entity12> data = entity12Repository.findById(1);
    }

    public void progress13(String address, Integer price, LocalDateTime inserted) {
        Entity13 data = new Entity13();
        data.setAddress(address);
        data.setPrice(price);
        data.setInsertAt(inserted);

        entity13Repository.save(data);
    }

    public Entity14 progress14(Integer id) {
        // findById(key) : key에 해당하는 record를 저장한 entity 객체를 리턴(Optional)
        Optional<Entity14> data = entity14Repository.findById(id);
        return data.orElse(null);
    }

    public Entity14 progress15(String name, Double score, String city) {
        // INSERT : save() 해당 entity 를 새 record 로 입력, 해당 entity에 매핑되는 record를 업데이트
        Entity14 data = new Entity14();
        data.setName(name);
        data.setScore(score);
        data.setCity(city);

        entity14Repository.save(data);

        return data;
    }

    public void progress16(Integer id, Double score) {
        // 1. 조회하고
        Entity14 data = entity14Repository.findById(id).get();

        // 2. 값 변경
        data.setScore(score);

        // 3. save
        entity14Repository.save(data);
    }

    public void progress17(Integer id, String address) {
        Entity13 data = entity13Repository.findById(id).get();
        data.setAddress(address);
        entity13Repository.save(data);
    }

    public void progress18(Integer id) {
        entity14Repository.deleteById(id);
    }
}
