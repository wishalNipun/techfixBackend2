package com.techfix.techfix_inventory_service.service;

import com.techfix.techfix_inventory_service.model.InventoryEntity;
import com.techfix.techfix_inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryProcessingService {

    private final InventoryRepository inventoryRepository;

    public InventoryProcessingService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryEntity addInventory(InventoryEntity inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<InventoryEntity> fetchInventoryByComponent(String componentName) {
        return inventoryRepository.findByComponentName(componentName);
    }

    public List<InventoryEntity> fetchInventoryBySupplier(String supplierName) {
        return inventoryRepository.findBySupplierName(supplierName);
    }

    public List<InventoryEntity> fetchAllInventory() {
        return inventoryRepository.findAll();
    }

    public InventoryEntity modifyInventory(Long id, InventoryEntity updated) {
        InventoryEntity inventoryEntity = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found."));
        inventoryEntity.setComponentName(updated.getComponentName());
        inventoryEntity.setSupplierName(updated.getSupplierName());
        inventoryEntity.setStockLevel(updated.getStockLevel());
        return inventoryRepository.save(inventoryEntity);
    }

    public void removeInventory(Long id) {
        InventoryEntity inventoryEntity = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found."));
        inventoryRepository.delete(inventoryEntity);
    }
}
