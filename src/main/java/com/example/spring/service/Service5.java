package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity18;
import com.example.spring.entity.Entity20;
import com.example.spring.repo.Entity16Repository;
import com.example.spring.repo.Entity18Repository;
import com.example.spring.repo.Entity20Repository;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service5 {

    private final Entity16Repository entity16Repository;
    private final Entity18Repository entity18Repository;
    private final Entity20Repository entity20Repository;

    public void action1(Integer page) {
        Page<Entity16> list = entity16Repository.findAll
                (PageRequest.of(page - 1, 10,
                        Sort.by("id").descending()));
        List<Entity16> list1 = list.getContent();
        for (Entity16 entity16 : list1) {
            System.out.println(entity16);
        }
    }

    public void action2(String country) {
        List<Entity16> list = entity16Repository.findByCountry(country); // 나쁜 예. 데이터 소모 큼
        list.forEach(System.out::println);
    }

    public void action3(String country, Integer page) {
        Page<Entity16> pageContent = entity16Repository.
                findByCountry(country, PageRequest.of(page - 1, 10,
                        Sort.by("id").descending()));
        List<Entity16> list = pageContent.getContent();
        for (Entity16 entity16 : list) {
            System.out.println(entity16);
        }
    }

    public void action4(String keyword, Integer page) {
        Page<Entity16> pageContent = entity16Repository.findByCustomerNameContainingIgnoreCaseOrContactNameContainingIgnoreCase
                (keyword, keyword, PageRequest.of(page - 1, 10,
                        Sort.by("id").descending()));
        List<Entity16> list = pageContent.getContent();
        for (Entity16 entity16 : list) {
            System.out.println(entity16);
        }
    }

    @Transactional
    public void action6(String country) {
        entity16Repository.deleteByCountry(country);
    }

    public void action7() {
        Entity20 gojo = entity20Repository.findById("Gojo").get();
        Entity20 geto = entity20Repository.findById("Geto").get();

        gojo.setMoney(gojo.getMoney() - 500);
        entity20Repository.save(gojo);

        if (true) {
            throw new RuntimeException("⚠️Network Error⚠️");
        }

        geto.setMoney(geto.getMoney() + 500);
        entity20Repository.save(geto);
    }

    @Transactional
    public void action8() {
        // 보통 service의 하나의 메소드가 하나의 transaction 임
        // -> @Transactional 어노테이션을 service의 모든 메소드에 붙여야 함.
        Entity20 gojo = entity20Repository.findById("Gojo").get();
        Entity20 geto = entity20Repository.findById("Geto").get();

        gojo.setMoney(gojo.getMoney() - 500);
        entity20Repository.save(gojo);

        if (true) throw new RuntimeException("⚠️Network Error⚠️");

        geto.setMoney(geto.getMoney() + 500);
        entity20Repository.save(geto);
    }

    @Transactional
    public void action9(String country) {
        entity18Repository.deleteByCountry(country);
    }

    @Transactional
    public void action10(String country) {
        // select 후 하나씩 지움 : 성능 이슈 있음
//        entity16Repository.deleteByCountry(country);

        // -> jpql 이나 sql로 직접 작성해서 지워야함
        entity16Repository.bulkDeleteByCountry(country);
    }

    @Transactional
    public void action11(String country) {
        entity18Repository.bulkDeleteByCountry(country);
    }
}
