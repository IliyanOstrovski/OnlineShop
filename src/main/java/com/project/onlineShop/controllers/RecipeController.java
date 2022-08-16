package com.project.onlineShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public record RecipeController() {
    @GetMapping("/recipe")
    public String recipePage(){
        return "recipe";
    }
}
