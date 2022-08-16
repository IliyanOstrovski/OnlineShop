package com.project.onlineShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompleteOrderController {
    @GetMapping("/completeOrder")
    public String completeOrderPage(){
        return "completeOrder";
    }
}
