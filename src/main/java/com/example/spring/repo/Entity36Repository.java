package com.example.spring.repo;

import com.example.spring.entity.Entity36;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Entity36Repository extends JpaRepository<Entity36, Integer> {
  void deleteByStudentId(int i);

  void deleteByLectureId(int i);
}