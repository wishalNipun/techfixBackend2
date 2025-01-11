package com.techfix.techfix_inventory_service.repository;
import com.techfix.techfix_inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByComponentName(String componentName);
    List<Inventory> findBySupplierName(String supplierName);
}
