package com.example.spring.spec;

import com.example.spring.entity.Entity19;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class Entity19Specification {

    public static Specification<Entity19> hasCategoryId(Integer cid) {
        return (root, query, cb) ->
                cid == null ? null : cb.equal(root.get("categoryId"), cid);
    }

    public static Specification<Entity19> hasSupplierId(Integer sid) {
        return (root, query, cb) ->
                sid == null ? null : cb.equal(root.get("supplierId"), sid);
    }

    public static Specification<Entity19> priceBetween(Integer p1, Integer p2) {
        return (root, query, cb) ->
                (p1 == null || p2 == null) ? null : cb.between(root.get("price"), p1, p2);
    }

    public static Specification<Entity19> priceGreaterThanEqual(Integer price) {
        return (root, query, cb) ->
                price == null ? null : cb.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Entity19> categoryIdIn(List<Integer> cids) {
        return (root, query, cb) ->
                (cids == null || cids.isEmpty()) ? null : root.get("categoryId").in(cids);
    }

    public static Specification<Entity19> productNameContains(String keyword) {
        return (root, query, cb) ->
                (keyword == null || keyword.isBlank()) ? null :
                        cb.like(root.get("productName"), "%" + keyword + "%");
    }
}
