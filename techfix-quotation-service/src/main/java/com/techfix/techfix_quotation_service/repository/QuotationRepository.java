package com.techfix.techfix_quotation_service.repository;

import com.techfix.techfix_quotation_service.model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
    List<Quotation> findByComponentName(String componentName);
    List<Quotation> findBySupplierName(String supplierName);
}
