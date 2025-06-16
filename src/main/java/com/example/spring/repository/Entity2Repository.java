package com.example.spring.repository;

import com.example.spring.entity.Entity2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity2Repository extends JpaRepository<Entity2, Integer> {
}
