package com.example.spring.repo;

import com.example.spring.entity.Entity8;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository // 사실 이거 생략 가능 jpa 때문에
public interface Entity8Repository extends JpaRepository<Entity8, Integer> {
}
