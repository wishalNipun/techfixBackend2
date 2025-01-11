package com.techfix.techfix_quotation_service.service;


import com.techfix.techfix_quotation_service.model.Quotation;
import com.techfix.techfix_quotation_service.repository.QuotationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuotationService {
    private final QuotationRepository quotationRepository;

    public QuotationService(QuotationRepository quotationRepository) {
        this.quotationRepository = quotationRepository;
    }

    public Quotation addQuotation(Quotation quotation) {
        return quotationRepository.save(quotation);
    }

    public List<Quotation> getQuotationsByComponent(String componentName) {
        return quotationRepository.findByComponentName(componentName);
    }

    public List<Quotation> getQuotationsBySupplier(String supplierName) {
        return quotationRepository.findBySupplierName(supplierName);
    }

    public List<Quotation> getAllQuotations() {
        return quotationRepository.findAll();
    }
}
