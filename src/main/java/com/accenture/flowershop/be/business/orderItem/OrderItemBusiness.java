package com.accenture.flowershop.be.business.orderItem;

import com.accenture.flowershop.be.entity.orderItem.OrderItem;

import java.util.List;

public interface OrderItemBusiness  {
    void addOrderItem(OrderItem orderItem);

    void removeOrderItem(OrderItem orderItem);

    void updateOrderItem(OrderItem orderItem);

    OrderItem getOrderItem(Long id);

    List<OrderItem> getAllOrderItem();

}
