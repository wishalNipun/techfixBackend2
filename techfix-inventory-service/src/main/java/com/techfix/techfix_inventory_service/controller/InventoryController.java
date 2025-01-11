package com.techfix.techfix_inventory_service.controller;


import com.techfix.techfix_inventory_service.model.Inventory;
import com.techfix.techfix_inventory_service.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        Inventory savedInventory = inventoryService.addInventory(inventory);
        return ResponseEntity.ok(savedInventory);
    }

    @GetMapping("/component/{componentName}")
    public ResponseEntity<List<Inventory>> getInventoryByComponent(@PathVariable String componentName) {
        List<Inventory> inventory = inventoryService.getInventoryByComponent(componentName);
        return ResponseEntity.ok(inventory);
    }

    @GetMapping("/supplier/{supplierName}")
    public ResponseEntity<List<Inventory>> getInventoryBySupplier(@PathVariable String supplierName) {
        List<Inventory> inventory = inventoryService.getInventoryBySupplier(supplierName);
        return ResponseEntity.ok(inventory);
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> inventory = inventoryService.getAllInventory();
        return ResponseEntity.ok(inventory);
    }
}
