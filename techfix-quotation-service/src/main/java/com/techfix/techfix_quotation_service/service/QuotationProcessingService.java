package com.techfix.techfix_quotation_service.service;

import com.techfix.techfix_quotation_service.model.QuotationEntity;
import com.techfix.techfix_quotation_service.repository.QuotationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationProcessingService {

    private final QuotationRepository quotationRepository;

    public QuotationProcessingService(QuotationRepository quotationRepository) {
        this.quotationRepository = quotationRepository;
    }

    public QuotationEntity addQuotation(QuotationEntity quotation) {
        return quotationRepository.save(quotation);
    }

    public List<QuotationEntity> getQuotationsByComponent(String componentName) {
        return quotationRepository.findByComponentName(componentName);
    }

    public List<QuotationEntity> getQuotationsBySupplier(String supplierName) {
        return quotationRepository.findBySupplierName(supplierName);
    }

    public List<QuotationEntity> getAllQuotations() {
        return quotationRepository.findAll();
    }

    public QuotationEntity modifyQuotation(Long id, QuotationEntity updated) {
        QuotationEntity quotation = quotationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quotation not found."));
        quotation.setComponentName(updated.getComponentName());
        quotation.setSupplierName(updated.getSupplierName());
        quotation.setAvailableQuantity(updated.getAvailableQuantity());
        quotation.setPrice(updated.getPrice());
        return quotationRepository.save(quotation);
    }

    public void removeQuotation(Long id) {
        QuotationEntity quotation = quotationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quotation not found."));
        quotationRepository.delete(quotation);
    }
}
