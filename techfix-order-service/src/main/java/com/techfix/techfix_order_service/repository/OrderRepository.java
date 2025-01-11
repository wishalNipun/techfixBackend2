package com.techfix.techfix_order_service.repository;

import com.techfix.techfix_order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findBySupplierName(String supplierName);
    List<Order> findByComponentName(String componentName);
}
