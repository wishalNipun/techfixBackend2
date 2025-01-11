package com.techfix.techfix_order_service.service;

import com.techfix.techfix_order_service.client.InventoryClient;
//import com.techfix.techfix_order_service.client.QuotationClient;
import com.techfix.techfix_order_service.model.Inventory;
import com.techfix.techfix_order_service.model.Order;
import com.techfix.techfix_order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
/*    @Qualifier("quotation-service")
    private final QuotationClient quotationClient;*/
    @Autowired
    private final InventoryClient inventoryClient;


    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {

        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public Order placeOrder(Order order) {
        // Optionally, verify inventory before placing order
        List<Inventory> inventories = inventoryClient.getInventoryByComponent(order.getComponentName());
        boolean isAvailable = inventories.stream()
                .anyMatch(inv -> inv.getSupplierName().equals(order.getSupplierName()) && inv.getStockLevel() >= order.getQuantity());

        if (!isAvailable) {
            order.setStatus("OUT_OF_STOCK");
        } else {
            order.setStatus("PLACED");
            // Optionally, update inventory here
        }

        return orderRepository.save(order);
    }

    public List<Order> getOrdersBySupplier(String supplierName) {
        return orderRepository.findBySupplierName(supplierName);
    }

    public List<Order> getOrdersByComponent(String componentName) {
        return orderRepository.findByComponentName(componentName);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
