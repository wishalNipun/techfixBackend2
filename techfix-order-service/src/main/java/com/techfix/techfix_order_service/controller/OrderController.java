package com.techfix.techfix_order_service.controller;

import com.techfix.techfix_order_service.model.Order;
import com.techfix.techfix_order_service.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order placedOrder = orderService.placeOrder(order);
        return ResponseEntity.ok(placedOrder);
    }

    @GetMapping("/supplier/{supplierName}")
    public ResponseEntity<List<Order>> getOrdersBySupplier(@PathVariable String supplierName) {
        List<Order> orders = orderService.getOrdersBySupplier(supplierName);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/component/{componentName}")
    public ResponseEntity<List<Order>> getOrdersByComponent(@PathVariable String componentName) {
        List<Order> orders = orderService.getOrdersByComponent(componentName);
        return ResponseEntity.ok(orders);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        Order updatedOrder = orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok(updatedOrder);
    }
}
