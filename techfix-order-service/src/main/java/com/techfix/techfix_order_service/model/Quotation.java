package com.techfix.techfix_order_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class Quotation {

    private Long id;

    private String componentName;
    private String supplierName;
    private Double price;

    public Quotation() {
    }

    public Quotation(Long id, String componentName, String supplierName, Double price, Integer availableQuantity) {
        this.id = id;
        this.componentName = componentName;
        this.supplierName = supplierName;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Long getId() {
        return id;
    }

    public String getComponentName() {
        return componentName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    private Integer availableQuantity;
}
