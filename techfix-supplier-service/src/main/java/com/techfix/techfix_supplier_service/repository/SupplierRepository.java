package com.techfix.techfix_supplier_service.repository;

import com.techfix.techfix_supplier_service.model.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    Optional<SupplierEntity> findByName(String name);
}
