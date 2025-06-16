package com.example.spring.repository;

import com.example.spring.entity.Entity5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity5Repository extends JpaRepository<Entity5, Integer> {
}
