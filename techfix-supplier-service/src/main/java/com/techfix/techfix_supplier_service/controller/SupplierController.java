package com.techfix.techfix_supplier_service.controller;

import com.techfix.techfix_supplier_service.model.SupplierEntity;
import com.techfix.techfix_supplier_service.service.SupplierProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierProcessingService supplierService;

    public SupplierController(SupplierProcessingService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<SupplierEntity> createSupplier(@RequestBody SupplierEntity supplier) {
        SupplierEntity savedSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.ok(savedSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierEntity> modifySupplier(@PathVariable Long id, @RequestBody SupplierEntity updated) {
        SupplierEntity updatedSupplier = supplierService.modifySupplier(id, updated);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeSupplier(@PathVariable Long id) {
        supplierService.removeSupplier(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<SupplierEntity>> fetchAllSuppliers() {
        List<SupplierEntity> suppliers = supplierService.fetchAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SupplierEntity> fetchSupplierByName(@PathVariable String name) {
        SupplierEntity supplier = supplierService.fetchSupplierByName(name);
        return ResponseEntity.ok(supplier);
    }
}
