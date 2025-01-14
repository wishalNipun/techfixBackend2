package com.techfix.techfix_order_service.repository;

import com.techfix.techfix_order_service.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findBySupplierName(String supplierName);
    List<OrderEntity> findByComponentName(String componentName);
}
