package com.techfix.techfix_order_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "orders") // 'order' is a reserved keyword in SQL
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String componentName;
    private String supplierName;
    private Integer quantity;
    private String status; // e.g., "PLACED", "SHIPPED", "DELIVERED"
    public Order() {
    }
    public Order(Long id, String componentName, String supplierName, Integer quantity, String status) {
        this.id = id;
        this.componentName = componentName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {


        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(componentName, order.componentName) && Objects.equals(supplierName, order.supplierName) && Objects.equals(quantity, order.quantity) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, componentName, supplierName, quantity, status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
