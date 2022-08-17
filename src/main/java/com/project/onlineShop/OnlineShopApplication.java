package com.project.onlineShop;

import com.project.onlineShop.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class OnlineShopApplication {

	@Autowired
	private EmailService emailService;


	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}
/*	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		emailService.sendEmail("iliyyaniordanov@gmail.com",
				"This is Subject",
				"This is test!");
	}*/
}
