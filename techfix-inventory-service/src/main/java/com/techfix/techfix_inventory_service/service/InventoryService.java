package com.techfix.techfix_inventory_service.service;

import com.techfix.techfix_inventory_service.model.Inventory;
import com.techfix.techfix_inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getInventoryByComponent(String componentName) {
        return inventoryRepository.findByComponentName(componentName);
    }

    public List<Inventory> getInventoryBySupplier(String supplierName) {
        return inventoryRepository.findBySupplierName(supplierName);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
}
