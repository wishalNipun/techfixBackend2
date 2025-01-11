package com.techfix.techfix_supplier_service.repository;

import com.techfix.techfix_supplier_service.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByName(String name);
}
