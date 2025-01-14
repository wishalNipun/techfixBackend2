package com.techfix.techfix_quotation_service.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "quotations")
public class QuotationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String componentName;
    private String supplierName;
    private Double price;
    private Integer availableQuantity;

    public QuotationEntity() {}

    public QuotationEntity(Long id, String componentName, String supplierName, Double price, Integer availableQuantity) {
        this.id = id;
        this.componentName = componentName;
        this.supplierName = supplierName;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuotationEntity that = (QuotationEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(componentName, that.componentName) &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(availableQuantity, that.availableQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, componentName, supplierName, price, availableQuantity);
    }

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getComponentName() { return componentName; }
    public void setComponentName(String componentName) { this.componentName = componentName; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getAvailableQuantity() { return availableQuantity; }
    public void setAvailableQuantity(Integer availableQuantity) { this.availableQuantity = availableQuantity; }
}
