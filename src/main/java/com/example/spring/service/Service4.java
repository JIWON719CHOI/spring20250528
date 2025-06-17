package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity19;
import com.example.spring.repo.Entity16Repository;
import com.example.spring.repo.Entity19Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service4 {
    private final Entity16Repository entity16Repository;
    private final Entity19Repository entity19Repository;


    public void action1() {
        // paging
        System.out.println("1111111111111111");
        Page<Entity16> list = entity16Repository.findAll(PageRequest.of(1 - 1, 10));
        List<Entity16> data = list.getContent();
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
        System.out.println("2222222222222222");
        List<Entity16> list2 = entity16Repository.findAll(PageRequest.of(2 - 1, 10)).getContent();
        for (Entity16 entity16 : list2) {
            System.out.println(entity16);
        }
    }

    public void action2() {
        System.out.println("1111111111111111");
        Page<Entity19> list = entity19Repository.findAll(PageRequest.of(1 - 1, 7));
        List<Entity19> data = list.getContent();
        for (Entity19 entity19 : data) {
            System.out.println(entity19);
        }
        System.out.println("22222222222222222");
        Page<Entity19> list2 = entity19Repository.findAll(PageRequest.of(2 - 1, 7));
        for (Entity19 entity19 : list2) {
            System.out.println(entity19);
        }
    }

    public void action3() {
        System.out.println("1️⃣1️⃣1️⃣1️⃣1️⃣1️⃣1️⃣1️⃣1️⃣1️⃣1️⃣1️⃣1️⃣");
        List<Entity19> list = entity19Repository
                .findAll(PageRequest.of(1 - 1, 7,
                        Sort.by("productName"))).getContent();
        for (Entity19 entity19 : list) {
            System.out.println(entity19);
        }
    }

    public void action4() {
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        List<Entity16> list = entity16Repository
                .findAll(PageRequest.of(1 - 1, 10,
                        // properties: Entity의 field 이름, descending() : 역순
                        Sort.by("contactName").descending())).getContent();
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        for (Entity16 entity16 : list) {
            System.out.println(entity16);
        }
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
    }

    public void action5() {
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        List<Entity19> list = entity19Repository
                .findAll(PageRequest.of(1 - 1, 10,
                        Sort.by("price").descending())).getContent();
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        for (Entity19 entity19 : list) {
            System.out.println(entity19);
        }
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
    }

    public void action6(Integer page) {
        System.out.println("📚" + page + "🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        Page<Entity16> page1 = entity16Repository.findAll(PageRequest.of(1 - 1, 10,
                Sort.by("id").descending()));
        List<Entity16> content1 = page1.getContent();
        int totalPages = page1.getTotalPages(); // 10
        long totalElements = page1.getTotalElements(); // 91
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        content1.forEach(System.out::println);
    }

    public void action7(Integer pageNumber) {
        System.out.println("📚" + pageNumber + "🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        PageRequest pageable = PageRequest.of(pageNumber - 1, 10, Sort.by("price"));
        Page<Entity19> page = entity19Repository.findAll(pageable);

        List<Entity19> content1 = page.getContent();
        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        boolean hasNext = page.hasNext();

        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        System.out.println("총 항목 수 = " + totalElements);
        System.out.println("총 페이지 수 = " + totalPages);
        System.out.println("현재 페이지 번호 = " + page.getNumber());
        System.out.println("다음 페이지 있음? " + page.hasNext());
        System.out.println("이전 페이지 있음? " + page.hasPrevious());
        System.out.println("첫 페이지임? " + page.isFirst());
        System.out.println("마지막 페이지임? " + page.isLast());
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
        System.out.println("🔽 현재 페이지 데이터 🔽");
        content1.forEach(System.out::println);
        System.out.println("🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸");
    }
}
