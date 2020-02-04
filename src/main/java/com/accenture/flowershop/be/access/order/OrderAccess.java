package com.accenture.flowershop.be.access.order;
import com.accenture.flowershop.be.entity.order.Order;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderAccess {

    void addOrder(Order order);

    void removeOrder(Order order);

    void updateOrder(Order order );

    Order getOrder(Long id);

    List<Order> getOrders();
}
