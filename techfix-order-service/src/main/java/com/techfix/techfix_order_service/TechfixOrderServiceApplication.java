package com.techfix.techfix_order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TechfixOrderServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TechfixOrderServiceApplication.class, args);
	}
}
