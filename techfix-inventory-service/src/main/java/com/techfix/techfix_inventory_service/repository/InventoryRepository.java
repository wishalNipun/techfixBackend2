package com.techfix.techfix_inventory_service.repository;

import com.techfix.techfix_inventory_service.model.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    List<InventoryEntity> findByComponentName(String componentName);
    List<InventoryEntity> findBySupplierName(String supplierName);
}
