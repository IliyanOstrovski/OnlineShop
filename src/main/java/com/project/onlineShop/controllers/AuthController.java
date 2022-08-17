package com.project.onlineShop.controllers;

import com.project.onlineShop.models.dtos.RegistrationDTO;
import com.project.onlineShop.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {
    private AuthService authService;



    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("registrationDTO")
    public RegistrationDTO initRegistrationDTO(){
        return new RegistrationDTO();
    }

    @GetMapping( "/register")
    public String register(){
        return "register";
    }

    @GetMapping("/login")
    public String login(){return "login";}

    @PostMapping("/register")
    public String register(@Valid RegistrationDTO registrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() || !this.authService.register(registrationDTO)){
            redirectAttributes.addFlashAttribute("registrationDTO",
                    registrationDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO",
                    bindingResult);

            return "redirect:/register";
        }
        return "redirect:/login";

    }
    }
