package com.techfix.techfix_quotation_service.repository;

import com.techfix.techfix_quotation_service.model.QuotationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotationRepository extends JpaRepository<QuotationEntity, Long> {
    List<QuotationEntity> findByComponentName(String componentName);
    List<QuotationEntity> findBySupplierName(String supplierName);
}
