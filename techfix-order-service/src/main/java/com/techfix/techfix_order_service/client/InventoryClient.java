package com.techfix.techfix_order_service.client;

import com.techfix.techfix_order_service.model.InventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service", url = "http://localhost:8082")
public interface InventoryClient {

    @GetMapping("/api/inventory/component/{componentName}")
    List<InventoryDTO> getInventoryByComponent(@PathVariable("componentName") String componentName);
}
