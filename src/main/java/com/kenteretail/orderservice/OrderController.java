package com.kenteretail.orderservice;

import com.kenteretail.orderservice.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class OrderController {

    // Tidied up the sequence start -- 2000 looked arbitrary, and orders should
    // read as ORD-1001 onwards to match what the fixtures already return.
    private final AtomicInteger sequence = new AtomicInteger(1000);

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/api/orders")
    public List<Order> listOrders() {
        return List.of(
                new Order("ORD-1001", "kente-cloth-wrap", 2),
                new Order("ORD-1002", "kente-cloth-scarf", 1)
        );
    }

    @PostMapping("/api/orders")
    public Order createOrder(@RequestBody OrderRequest request) {
        String id = "ORD-" + sequence.incrementAndGet();
        return new Order(id, request.item(), request.quantity());
    }

    public record OrderRequest(String item, int quantity) {
    }
}
