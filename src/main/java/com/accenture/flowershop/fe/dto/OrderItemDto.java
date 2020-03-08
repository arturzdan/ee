package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;

public class OrderItemDto {
    private Long id;
    private Flower flower;
    private Order order;
    private int count;

    public OrderItemDto() {
    }

    public OrderItemDto(Long id, Flower flower, Order order, int count) {
        this.id = id;
        this.flower = flower;
        this.order = order;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
