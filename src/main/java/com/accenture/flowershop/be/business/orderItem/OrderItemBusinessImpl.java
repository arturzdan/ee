package com.accenture.flowershop.be.business.orderItem;

import com.accenture.flowershop.be.access.orderItem.OrderItemAccess;
import com.accenture.flowershop.be.entity.orderItem.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemBusinessImpl implements OrderItemBusiness {

    @Autowired
    private OrderItemAccess orderItemAccess;

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemAccess.addOrderItem(orderItem);
    }

    @Override
    public void removeOrderItem(OrderItem orderItem) {
        orderItemAccess.removeOrderItem(orderItem);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        orderItemAccess.updateOrderItem(orderItem);
    }

    @Override
    public OrderItem getOrderItem(Long id) {
        return orderItemAccess.getOrderItem(id);
    }

    @Override
    public List<OrderItem> getAllOrderItem() {
        return getAllOrderItem();
    }
}
