package com.techfix.techfix_order_service.client;

import com.techfix.techfix_order_service.config.FeignConfig;
import com.techfix.techfix_order_service.model.Quotation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "quotation-service", url = "http://localhost:8081")
public interface QuotationClient {
    @GetMapping("/api/quotations/component/{componentName}")
    List<Quotation> getQuotationsByComponent(@PathVariable("componentName") String componentName);
}
