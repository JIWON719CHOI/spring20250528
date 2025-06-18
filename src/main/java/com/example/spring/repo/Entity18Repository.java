package com.example.spring.repo;

import com.example.spring.entity.Entity18;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity18Repository extends JpaRepository<Entity18, Integer> {

    @Query("SELECT e18 From Entity18 AS e18 WHERE e18.city LIKE :city")
    List<Entity18> findByCity(String city);

    // SELECT * FROM supplier WHERE county IN (?, ?, ?) ORDER BY supplier_name
    // SELECT * FROM supplier WHERE supplier_name LIKE :keyword ORDER BY supplier_name DESC
    // query method 만들기

    List<Entity18> findByCountryInOrderBySupplierName(List<String> countries);

    List<Entity18> findBySupplierNameLikeOrderBySupplierNameDesc(String keyword);

    void deleteByCountry(String country);

    @Modifying
    @Query("DELETE FROM Entity18 e18 WHERE e18.country = :country")
    void bulkDeleteByCountry(String country);
}