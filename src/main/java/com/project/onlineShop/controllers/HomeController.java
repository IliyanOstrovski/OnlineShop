package com.project.onlineShop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String loggedOutUser(){
        return "index";
    }

    @GetMapping("/home")
    public String loggedInUser(){
        return "home";
    }

}
