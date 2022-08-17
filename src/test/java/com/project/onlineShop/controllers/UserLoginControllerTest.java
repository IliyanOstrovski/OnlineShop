package com.project.onlineShop.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserLoginControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void testLoginShow() throws Exception{
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void testUseSuccessfulLogin() throws Exception{
        mockMvc.perform(post("/login").
                        param("username", "iliyan").
                        param("password", "1111")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/home"));
      }







}
