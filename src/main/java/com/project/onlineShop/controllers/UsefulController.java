package com.project.onlineShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsefulController {
    @GetMapping("/useful")
    public String usefulPage(){
        return "useful";
    }
}
