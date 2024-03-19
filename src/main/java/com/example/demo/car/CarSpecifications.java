package com.example.demo.car;

import org.springframework.data.jpa.domain.Specification;

public class CarSpecifications {

    // Create a specification to filter by a specific attribute and value
    public static Specification<Car> attributeEquals(String attributeName, Object value) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(attributeName), value);
        };
    }
    
    public static Specification<Car> attributeLessEq(String attributeName, int value) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.lessThanOrEqualTo(root.get(attributeName), value);
        };
    }
}