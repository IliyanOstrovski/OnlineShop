package com.project.onlineShop.controllers;

import com.project.onlineShop.models.Products;
import com.project.onlineShop.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsController {

    @GetMapping("/products")
    public String productsPage(){
        return "products";
    }
}
