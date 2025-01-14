package com.techfix.techfix_inventory_service.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "inventory")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String componentName;
    private String supplierName;
    private Integer stockLevel;

    public InventoryEntity() {
    }

    public InventoryEntity(Long id, String componentName, String supplierName, Integer stockLevel) {
        this.id = id;
        this.componentName = componentName;
        this.supplierName = supplierName;
        this.stockLevel = stockLevel;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InventoryEntity that = (InventoryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(componentName, that.componentName) &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(stockLevel, that.stockLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, componentName, supplierName, stockLevel);
    }

    // Getters / Setters omitted for brevity
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getComponentName() { return componentName; }
    public void setComponentName(String componentName) { this.componentName = componentName; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public Integer getStockLevel() { return stockLevel; }
    public void setStockLevel(Integer stockLevel) { this.stockLevel = stockLevel; }
}
