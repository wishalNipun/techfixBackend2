package com.techfix.techfix_quotation_service.controller;
import com.techfix.techfix_quotation_service.model.Quotation;
import com.techfix.techfix_quotation_service.service.QuotationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/quotations")
public class QuotationController {
    private final QuotationService quotationService;

    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @PostMapping
    public ResponseEntity<Quotation> addQuotation(@RequestBody Quotation quotation) {
        Quotation savedQuotation = quotationService.addQuotation(quotation);
        return ResponseEntity.ok(savedQuotation);
    }

    @GetMapping("/component/{componentName}")
    public ResponseEntity<List<Quotation>> getQuotationsByComponent(@PathVariable String componentName) {
        List<Quotation> quotations = quotationService.getQuotationsByComponent(componentName);
        return ResponseEntity.ok(quotations);
    }

    @GetMapping("/supplier/{supplierName}")
    public ResponseEntity<List<Quotation>> getQuotationsBySupplier(@PathVariable String supplierName) {
        List<Quotation> quotations = quotationService.getQuotationsBySupplier(supplierName);
        return ResponseEntity.ok(quotations);
    }

    @GetMapping
    public ResponseEntity<List<Quotation>> getAllQuotations() {
        List<Quotation> quotations = quotationService.getAllQuotations();

        return ResponseEntity.ok(quotations);
    }
}
