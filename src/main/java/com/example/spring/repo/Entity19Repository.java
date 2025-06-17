package com.example.spring.repo;

import com.example.spring.entity.Entity19;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity19Repository extends JpaRepository<Entity19, Integer>, JpaSpecificationExecutor<Entity19> {

    // ✒️ 연습 8개 메소드 만들기
    // SELECT * FROM product WHERE category_id = :categoryId
    // SELECT * FROM product WHERE supplier_id = :supplierId
    // SELECT * FROM product WHERE price BETWEEN :p1 AND :p2
    // SELECT * FROM product WHERE price >= :p1 AND price <= :p2
    // SELECT * FROM product WHERE price >= :price
    // SELECT * FROM product WHERE category_id IN (?, ?...?)
    // SELECT * FROM product WHERE product_name LIKE :keyword

    // ✅ Method name 기반 쿼리로 대부분 처리 가능
    List<Entity19> findByCategoryId(int categoryId);

    List<Entity19> findBySupplierId(int supplierId);

    List<Entity19> findByPriceBetween(Double price, Double price2); // Between 쿼리 자동

    List<Entity19> findByPriceGreaterThanEqual(Double price); // >= 쿼리 자동

    List<Entity19> findByCategoryIdIn(List<Integer> categoryIds); // IN 쿼리 자동

    List<Entity19> findByProductNameContaining(String keyword); // LIKE %keyword%

    // ✅ NativeQuery로 정확히 일치하는 검색 (LIKE 아님)
    @Query(value = "SELECT * FROM jpa.product WHERE product_name = :keyword", nativeQuery = true)
    List<Entity19> findByProductNameExact(String keyword);

    // ✅ SELECT * FROM product WHERE category_id = :id ORDER BY price DESC
    @Query(value = "SELECT * FROM jpa.product WHERE category_id = :id ORDER BY price DESC", nativeQuery = true)
    List<Entity19> query14(Integer id);

    // ✅ ORDER BY price ASC
    @Query("SELECT e19 FROM Entity19 AS e19 WHERE e19.categoryId = :id ORDER BY e19.price")
    List<Entity19> query15(Integer id);
}
