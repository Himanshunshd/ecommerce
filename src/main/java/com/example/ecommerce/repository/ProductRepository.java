package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;    // I want to use the JpaRepository interface provided by Spring Data JPA."

import java.math.BigDecimal;
import java.util.List; 

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName (String name) ;   // important If a search field is not unique (like product name), use List<Product> because multiple products can match.
    List<Product> findByNameAndPrice (String name , BigDecimal price)  ;
}
 