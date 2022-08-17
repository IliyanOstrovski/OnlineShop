package com.project.onlineShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @GetMapping("/products")
    public String productsPage(){
        return "products";
    }
}
