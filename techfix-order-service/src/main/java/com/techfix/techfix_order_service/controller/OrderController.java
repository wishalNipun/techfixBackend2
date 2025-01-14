package com.techfix.techfix_order_service.controller;

import com.techfix.techfix_order_service.model.OrderEntity;
import com.techfix.techfix_order_service.service.OrderProcessingService;
import org.hibernate.criterion.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderProcessingService orderService;

    public OrderController(OrderProcessingService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
        OrderEntity placedOrder = orderService.placeOrder(order);
        return ResponseEntity.ok(placedOrder);
    }

    @GetMapping("/supplier/{supplierName}")
    public ResponseEntity<List<OrderEntity>> getOrdersBySupplier(@PathVariable String supplierName) {
        List<OrderEntity> orders = orderService.findOrdersBySupplier(supplierName);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/component/{componentName}")
    public ResponseEntity<List<OrderEntity>> getOrdersByComponent(@PathVariable String componentName) {
        List<OrderEntity> orders = orderService.findOrdersByComponent(componentName);
        return ResponseEntity.ok(orders);
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orders = orderService.findAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderEntity> changeOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        OrderEntity updated = orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody OrderEntity updatedOrder) {
        OrderEntity result = orderService.updateOrder(id, updatedOrder);
        return ResponseEntity.ok(result);
    }

}
