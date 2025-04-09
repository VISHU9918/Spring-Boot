package com.example.jpacrud.datarest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpacrud.datarest.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
