package com.example.spring.repository;

import com.example.spring.entity.Entity3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity3Repository extends JpaRepository<Entity3, Integer> {
}
