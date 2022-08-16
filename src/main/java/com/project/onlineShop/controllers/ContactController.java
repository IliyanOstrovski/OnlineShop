package com.project.onlineShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping("/contacts")
    public String contactPage(){
        return "contacts";
    }
}
