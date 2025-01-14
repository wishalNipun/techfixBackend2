package com.techfix.techfix_quotation_service.controller;

import com.techfix.techfix_quotation_service.model.QuotationEntity;
import com.techfix.techfix_quotation_service.service.QuotationProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotations")
public class QuotationController {

    private final QuotationProcessingService quotationService;

    public QuotationController(QuotationProcessingService quotationService) {
        this.quotationService = quotationService;
    }

    @PostMapping
    public ResponseEntity<QuotationEntity> createQuotation(@RequestBody QuotationEntity quotation) {
        QuotationEntity savedQuotation = quotationService.addQuotation(quotation);
        return ResponseEntity.ok(savedQuotation);
    }

    @GetMapping("/component/{componentName}")
    public ResponseEntity<List<QuotationEntity>> getByComponent(@PathVariable String componentName) {
        List<QuotationEntity> list = quotationService.getQuotationsByComponent(componentName);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/supplier/{supplierName}")
    public ResponseEntity<List<QuotationEntity>> getBySupplier(@PathVariable String supplierName) {
        List<QuotationEntity> list = quotationService.getQuotationsBySupplier(supplierName);
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<QuotationEntity>> fetchAllQuotations() {
        List<QuotationEntity> quotations = quotationService.getAllQuotations();
        return ResponseEntity.ok(quotations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuotationEntity> modifyQuotation(@PathVariable Long id, @RequestBody QuotationEntity updated) {
        QuotationEntity updatedQuotation = quotationService.modifyQuotation(id, updated);
        return ResponseEntity.ok(updatedQuotation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeQuotation(@PathVariable Long id) {
        quotationService.removeQuotation(id);
        return ResponseEntity.noContent().build();
    }
}
