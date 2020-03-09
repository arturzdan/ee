package com.accenture.flowershop.be.access.orderItem;

import com.accenture.flowershop.be.entity.orderItem.OrderItem;

import java.util.List;

public interface OrderItemAccess {
    void addOrderItem(OrderItem orderItem);

    void removeOrderItem(OrderItem orderItem);

    void updateOrderItem(OrderItem orderItem );

    OrderItem getOrderItem(Long id);

    List<OrderItem> getOrderItems();

}
