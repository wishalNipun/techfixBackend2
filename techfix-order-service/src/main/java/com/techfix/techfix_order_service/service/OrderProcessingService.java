package com.techfix.techfix_order_service.service;

import com.techfix.techfix_order_service.client.InventoryClient;
import com.techfix.techfix_order_service.model.InventoryDTO;
import com.techfix.techfix_order_service.model.OrderEntity;
import com.techfix.techfix_order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProcessingService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderProcessingService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public OrderEntity placeOrder(OrderEntity order) {
        // Check inventory before placing
        List<InventoryDTO> availableInventory = inventoryClient.getInventoryByComponent(order.getComponentName());
        boolean isInStock = availableInventory.stream()
                .anyMatch(inv -> inv.getSupplierName().equals(order.getSupplierName()) &&
                        inv.getStockLevel() >= order.getQuantity());

        if (!isInStock) {
            order.setStatus("OUT_OF_STOCK");
        } else {
            order.setStatus("PLACED");
            // Optionally, you could call a method to decrement stock if desired.
        }

        return orderRepository.save(order);
    }

    public List<OrderEntity> findOrdersBySupplier(String supplierName) {
        return orderRepository.findBySupplierName(supplierName);
    }

    public List<OrderEntity> findOrdersByComponent(String componentName) {
        return orderRepository.findByComponentName(componentName);
    }

    public List<OrderEntity> findAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity updateOrderStatus(Long orderId, String status) {
        OrderEntity existing = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existing.setStatus(status);
        return orderRepository.save(existing);
    }

    public OrderEntity updateOrder(Long id, OrderEntity updatedOrder) {
        OrderEntity existing = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existing.setComponentName(updatedOrder.getComponentName());
        existing.setSupplierName(updatedOrder.getSupplierName());
        existing.setQuantity(updatedOrder.getQuantity());
        existing.setStatus(updatedOrder.getStatus());
        return orderRepository.save(existing);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
