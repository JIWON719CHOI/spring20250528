package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity17;
import com.example.spring.entity.Entity18;
import com.example.spring.entity.Entity19;
import com.example.spring.repo.Entity16Repository;
import com.example.spring.repo.Entity17Repository;
import com.example.spring.repo.Entity18Repository;
import com.example.spring.repo.Entity19Repository;
import com.example.spring.spec.Entity19Specification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Service3 {

    private final Entity16Repository entity16Repository;
    private final Entity17Repository entity17Repository;
    private final Entity18Repository entity18Repository;
    private final Entity19Repository entity19Repository;

    public void action1() {
        // findById() : pk 로 하나의 레코드 조회
        Entity16 entity16 = entity16Repository.findById(1).get();
        System.out.println(entity16);
    }

    public void action2() {
        // findAll() : 모든 레코드 조회
        List<Entity16> entity16List = entity16Repository.findAll();
        System.out.println(entity16List.size());
    }

    public void action3() {
        List<Entity17> entity17List = entity17Repository.findAll();
        System.out.println(entity17List.size());

        // 향상된 for 문
        for (Entity17 entity17 : entity17List) {
            System.out.println(entity17);
        }
    }

    public void action4(String country) {
        /*
        SELECT *
        FROM customer
        WHERE country = 'usa'
         */
        List<Entity16> data = entity16Repository.query4(country);
        System.out.println("data.size() = " + data.size());

        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action5(String city) {
        List<Entity16> data = entity16Repository.query5(city);
        System.out.println("data.size() = " + data.size());
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action6(LocalDate start, LocalDate end) {
        List<Entity17> data = entity17Repository.query6(start, end);
        System.out.println("data.size() = " + data.size());
        for (Entity17 entity17 : data) {
            System.out.println(entity17);
        }
    }

    public void action7(String keyword) {
        List<Entity17> data = entity17Repository.query7("%" + keyword + "%");
        for (Entity17 entity17 : data) {
            System.out.println(entity17);
        }
    }

    public void action8(String country) {
        List<Entity16> data = entity16Repository.query8("%" + country + "%");
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action9(String city) {
        List<Entity16> data = entity16Repository.query9("%" + city + "%");
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action10(String name) {
        List<Entity17> data = entity17Repository.query10("%" + name + "%");
        for (Entity17 entity17 : data) {
            System.out.println(entity17);
        }
    }

    public void action11(LocalDate start, LocalDate end) {
        List<Entity17> data = entity17Repository.findByBirthDateBetween(start, end);
        for (Entity17 entity17 : data) {
            System.out.println(entity17);
        }
    }

    public void action12(String city) {
        List<Entity18> data = entity18Repository.findByCity(city);
        for (Entity18 entity18 : data) {
            System.out.println(entity18);
        }
    }

    public void action13(Integer cid, Integer sid, Integer p1, Integer p2,
                         Integer price, List<Integer> cids, String keyword) {

        Specification<Entity19> spec = null;

        if (cid != null) {
            spec = Entity19Specification.hasCategoryId(cid);
        }
        if (sid != null) {
            spec = (spec == null)
                    ? Entity19Specification.hasSupplierId(sid)
                    : spec.and(Entity19Specification.hasSupplierId(sid));
        }
        if (p1 != null && p2 != null) {
            spec = (spec == null)
                    ? Entity19Specification.priceBetween(p1, p2)
                    : spec.and(Entity19Specification.priceBetween(p1, p2));
        }
        if (price != null) {
            spec = (spec == null)
                    ? Entity19Specification.priceGreaterThanEqual(price)
                    : spec.and(Entity19Specification.priceGreaterThanEqual(price));
        }
        if (cids != null && !cids.isEmpty()) {
            spec = (spec == null)
                    ? Entity19Specification.categoryIdIn(cids)
                    : spec.and(Entity19Specification.categoryIdIn(cids));
        }
        if (keyword != null && !keyword.isBlank()) {
            spec = (spec == null)
                    ? Entity19Specification.productNameContains(keyword)
                    : spec.and(Entity19Specification.productNameContains(keyword));
        }


        List<Entity19> data = (spec == null)
                ? entity19Repository.findAll()
                : entity19Repository.findAll(spec);


        for (Entity19 item : data) {
            System.out.println(item);
        }
    }

    public void action14(Integer id) {
        List<Entity19> data = entity19Repository.query14(id);
        for (Entity19 item : data) {
            System.out.println(item);
        }
    }

    public void action15(Integer id) {
        List<Entity19> data = entity19Repository.query15(id);
        for (Entity19 item : data) {
            System.out.println(item);
        }
    }

    public void action16(List<String> countries, String keyword) {
        List<Entity18> data1 = entity18Repository.findByCountryInOrderBySupplierName(countries);
        List<Entity18> data2 = entity18Repository.findBySupplierNameLikeOrderBySupplierNameDesc("%" + keyword + "%");
        for (Entity18 entity18 : data1) {
            System.out.println(entity18);
        }
        for (Entity18 entity18 : data2) {
            System.out.println(entity18);
        }
    }
}
