package com.techfix.techfix_supplier_service.service;

import com.techfix.techfix_supplier_service.model.SupplierEntity;
import com.techfix.techfix_supplier_service.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierProcessingService {

    private final SupplierRepository supplierRepository;

    public SupplierProcessingService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierEntity createSupplier(SupplierEntity supplier) {
        return supplierRepository.save(supplier);
    }

    public SupplierEntity modifySupplier(Long id, SupplierEntity updated) {
        SupplierEntity existing = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found."));
        existing.setName(updated.getName());
        existing.setContactEmail(updated.getContactEmail());
        existing.setContactPhone(updated.getContactPhone());
        return supplierRepository.save(existing);
    }

    public void removeSupplier(Long id) {
        SupplierEntity supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found."));
        supplierRepository.delete(supplier);
    }

    public List<SupplierEntity> fetchAllSuppliers() {
        return supplierRepository.findAll();
    }

    public SupplierEntity fetchSupplierByName(String name) {
        return supplierRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Supplier not found."));
    }
}
