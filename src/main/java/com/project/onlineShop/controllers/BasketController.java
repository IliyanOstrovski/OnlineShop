package com.project.onlineShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController {
    @GetMapping("/basket")
    public String usefulPage(){
        return "basket";
    }
}
