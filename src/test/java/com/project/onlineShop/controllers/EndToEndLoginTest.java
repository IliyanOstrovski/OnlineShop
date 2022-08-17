package com.project.onlineShop.controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class EndToEndLoginTest {
    @Autowired
    private MockMvc mockMvc;

    @org.testng.annotations.Test
    void openHomePage() throws Exception {
        //First should run it, before start the test!!!


        //initialise Driver
        String expectedUrl = "localhost:8080/home";
       System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        //opening Browser
        driver.manage().window().maximize();
        driver.get("localhost:8080/login");
        Thread.sleep(1000);

        //writing username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("iliyan");

        //writing password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1111");
        Thread.sleep(1000);

        //clicking on login button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(2000);

        //end of test
        driver.close();
    }

}
