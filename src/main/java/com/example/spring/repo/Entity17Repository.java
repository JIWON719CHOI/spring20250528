package com.example.spring.repo;

import com.example.spring.entity.Entity17;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface Entity17Repository extends JpaRepository<Entity17, Integer> {
    @Query(value = """
            SELECT * FROM jpa.employee WHERE birth_date BETWEEN :start AND :end
            """, nativeQuery = true)
    List<Entity17> query6(LocalDate start, LocalDate end);

    @Query(value = """
            SELECT * FROM jpa.employee WHERE first_name LIKE :keyword OR last_name LIKE :keyword
            """, nativeQuery = true)
    List<Entity17> query7(String keyword);


    @Query("""
            SELECT e17 FROM Entity17 AS e17 WHERE e17.firstName LIKE :name OR e17.lastName LIKE :name
            """)
    List<Entity17> query10(String name);

    @Query("""
            SELECT e17 FROM Entity17 AS e17 WHERE e17.birthDate BETWEEN :start AND :end
            """)
    List<Entity17> findByBirthDateBetween(LocalDate start, LocalDate end);

}