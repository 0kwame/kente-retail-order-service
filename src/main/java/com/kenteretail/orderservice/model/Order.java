package com.kenteretail.orderservice.model;

public class Order {

    private final String id;
    private final String item;
    private final int quantity;

    public Order(String id, String item, int quantity) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
