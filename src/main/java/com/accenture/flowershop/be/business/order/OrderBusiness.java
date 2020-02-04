package com.accenture.flowershop.be.business.order;

import com.accenture.flowershop.be.entity.order.Order;
import java.util.List;

public interface OrderBusiness {

    void addOrder(Order order);

    void removeOrder(Order order);

    void updateOrder(Order order);

    Order getOrder(Long id);

    List<Order> getAllOrder();
}
