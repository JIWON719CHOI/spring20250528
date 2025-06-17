package com.example.spring.repo;

import com.example.spring.entity.Entity10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity10Repository extends JpaRepository<Entity10, Integer> {
    // find...
    // save
    // delect
    // 전부 JpaRepository로 자동으로 만들어준다.
    // ai가 자꾸 Long 으로 써주는 이유 : 실무에서 자주 쓰는 크기가 커서...
}
