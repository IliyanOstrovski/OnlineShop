package com.project.onlineShop.repositories;

import com.project.onlineShop.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
