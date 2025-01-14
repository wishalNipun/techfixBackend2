package com.techfix.techfix_inventory_service.controller;

import com.techfix.techfix_inventory_service.model.InventoryEntity;
import com.techfix.techfix_inventory_service.service.InventoryProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryProcessingService inventoryService;

    public InventoryController(InventoryProcessingService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<InventoryEntity> createInventory(@RequestBody InventoryEntity inventory) {
        InventoryEntity saved = inventoryService.addInventory(inventory);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/component/{componentName}")
    public ResponseEntity<List<InventoryEntity>> getInventoryByComponent(@PathVariable String componentName) {
        List<InventoryEntity> list = inventoryService.fetchInventoryByComponent(componentName);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/supplier/{supplierName}")
    public ResponseEntity<List<InventoryEntity>> getInventoryBySupplier(@PathVariable String supplierName) {
        List<InventoryEntity> list = inventoryService.fetchInventoryBySupplier(supplierName);
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<InventoryEntity>> getAllInventory() {
        List<InventoryEntity> list = inventoryService.fetchAllInventory();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryEntity> modifyInventory(@PathVariable Long id, @RequestBody InventoryEntity updated) {
        InventoryEntity updatedInventory = inventoryService.modifyInventory(id, updated);
        return ResponseEntity.ok(updatedInventory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeInventory(@PathVariable Long id) {
        inventoryService.removeInventory(id);
        return ResponseEntity.noContent().build();
    }

}
