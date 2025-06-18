package com.example.spring.repo;

import com.example.spring.entity.Entity16;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity16Repository extends JpaRepository<Entity16, Integer> {

    // findById
    // save
    // deleteById

    @Query(value = """
            SELECT * FROM jpa.customer WHERE country = :country
            """, nativeQuery = true)
    List<Entity16> query4(String country);

    @Query(value = """
            SELECT * FROM jpa.customer WHERE city = :city
            """, nativeQuery = true)
    List<Entity16> query5(String city);

    /* sql
    @Query(value = """
            SELECT * FROM jpa.customer WHERE country = :country
            """, nativeQuery = true) */

    // JPQL : entity 대상 쿼리. e16.country 는 entity의 속성이다. 위 query1 과 하는 일은 같다.
    @Query("""
            SELECT e16 FROM Entity16 AS e16 WHERE e16.country LIKE :country
            """)
    List<Entity16> query8(String country);

    // query9 라는 이름은 findBy어쩌구 식으로 메소드 직접 만들기.. 이름 쓸 수 있음
    @Query("""
            SELECT e16 FROM Entity16  AS e16 WHERE e16.city LIKE:city
            """)
    List<Entity16> query9(String city);

    List<Entity16> findByCountry(String country);

    Page<Entity16> findByCountry(String country, PageRequest pageRequest);

    Page<Entity16> findByCustomerNameContainingIgnoreCaseOrContactNameContainingIgnoreCase(String keyword1, String keyword2, PageRequest pageRequest);

    void deleteByCountry(String country);

    @Modifying
    @Query("DELETE FROM Entity16 AS e16 WHERE e16.country = :country")
    void bulkDeleteByCountry(String country);
}