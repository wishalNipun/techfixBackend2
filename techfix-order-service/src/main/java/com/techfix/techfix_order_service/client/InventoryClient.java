package com.techfix.techfix_order_service.client;

import com.techfix.techfix_order_service.config.FeignConfig;
import com.techfix.techfix_order_service.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "inventory-service", url = "http://localhost:8082")
public interface InventoryClient {
    @GetMapping("/api/inventory/component/{componentName}")
    List<Inventory> getInventoryByComponent(@PathVariable("componentName") String componentName);
}
