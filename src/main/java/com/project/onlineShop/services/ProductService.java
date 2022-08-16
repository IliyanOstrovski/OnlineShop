package com.project.onlineShop.services;

import com.project.onlineShop.models.Products;
import com.project.onlineShop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> allProducts() {
       return productRepository.findAll();
    }
}
