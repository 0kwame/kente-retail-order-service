package com.kenteretail.orderservice;

import com.kenteretail.orderservice.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderControllerTest {

    private final OrderController controller = new OrderController();

    @Test
    void healthReturnsOk() {
        assertEquals("OK", controller.health());
    }

    @Test
    void listOrdersReturnsSeedFixtures() {
        List<Order> orders = controller.listOrders();
        assertEquals(2, orders.size());
    }

    @Test
    void createOrderAssignsAGeneratedId() {
        Order order = controller.createOrder(new OrderController.OrderRequest("kente-cloth-runner", 3));
        assertNotNull(order.getId());
        assertTrue(order.getId().startsWith("ORD-"));
    }

    @Test
    void placeholderRegressionCheck() {
        // TODO(learner): this was left as a placeholder before the checkout-fix
        // work landed -- replace it with a real assertion once you've picked up
        // the ticket. It intentionally proves nothing yet.
        assertTrue(true);
    }
}
