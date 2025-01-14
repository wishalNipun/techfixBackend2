package com.techfix.techfix_order_service.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders") // 'order' is reserved in SQL
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String componentName;
    private String supplierName;
    private Integer quantity;
    private String status; // e.g., "PLACED", "OUT_OF_STOCK", "SHIPPED", etc.

    public OrderEntity() {
    }

    public OrderEntity(Long id, String componentName, String supplierName, Integer quantity, String status) {
        this.id = id;
        this.componentName = componentName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.status = status;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(componentName, that.componentName) &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, componentName, supplierName, quantity, status);
    }

    // Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getComponentName() { return componentName; }
    public void setComponentName(String componentName) { this.componentName = componentName; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
