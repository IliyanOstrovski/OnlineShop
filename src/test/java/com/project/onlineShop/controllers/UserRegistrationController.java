package com.project.onlineShop.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import javax.persistence.Table;


@SpringBootTest()
@AutoConfigureMockMvc
public class UserRegistrationController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegisterShow() throws Exception{
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk());
    }

    @Test
    void testUserRegister() throws Exception{
       mockMvc.perform(post("/register").
               param("email", "gosho@gmail.com").
               param("username", "gosho").
               param("password", "1111").
               param("confirmPassword", "1111")
                       .with(csrf()))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/login"));

    }
}
