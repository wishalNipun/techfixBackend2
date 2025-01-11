package com.techfix.techfix_order_service.config;

import com.techfix.techfix_order_service.client.InventoryClient;
import feign.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}