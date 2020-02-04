package com.accenture.flowershop.be.business.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.flowershop.be.access.order.OrderAccess;
import com.accenture.flowershop.be.entity.order.Order;

import java.util.List;


@Service
public class OrderBusinessImpl implements OrderBusiness {

    @Autowired
    private OrderAccess orderAccess;

    @Override
    public void addOrder(Order order) {
        orderAccess.addOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderAccess.updateOrder(order);
    }

    @Override
    public void removeOrder(Order order) {
        orderAccess.removeOrder(order);
    }

    @Override
    public Order getOrder(Long id) {
        return orderAccess.getOrder(id);
    }

    @Override
    public List<Order> getAllOrder() {
        return null;
    }
}
