package com.example.spring.service;

import com.example.spring.entity.Entity21;
import com.example.spring.entity.Entity22;
import com.example.spring.repo.Entity21Repository;
import com.example.spring.repo.Entity22Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class Service6 {

    private final Entity21Repository entity21Repository;
    private final Entity22Repository entity22Repository;

    public void action1(String name, String address) {
        Entity21 entity21 = new Entity21();
        entity21.setName(name);
        entity21.setAddress(address);
        entity21Repository.save(entity21);
    }

    public void action2(String name, String address, String country) {
        Entity22 entity22 = new Entity22();
        entity22.setName(name);
        entity22.setAddress(address);
        entity22.setCountry(country);
        entity22Repository.save(entity22);
    }
}
