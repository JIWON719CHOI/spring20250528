package com.example.spring.repository;

import com.example.spring.entity.Entity4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity4Repository extends JpaRepository<Entity4, Integer> {
}
