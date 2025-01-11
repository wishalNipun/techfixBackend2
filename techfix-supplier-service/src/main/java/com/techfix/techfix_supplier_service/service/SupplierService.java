package com.techfix.techfix_supplier_service.service;

import com.techfix.techfix_supplier_service.model.Supplier;
import com.techfix.techfix_supplier_service.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier supplierDetails) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setName(supplierDetails.getName());
        supplier.setContactEmail(supplierDetails.getContactEmail());
        supplier.setContactPhone(supplierDetails.getContactPhone());
        // Update additional fields as necessary
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplierRepository.delete(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierByName(String name) {
        return supplierRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }
}
