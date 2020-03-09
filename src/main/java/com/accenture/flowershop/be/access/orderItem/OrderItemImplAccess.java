package com.accenture.flowershop.be.access.orderItem;

import com.accenture.flowershop.be.entity.orderItem.OrderItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class OrderItemImplAccess implements OrderItemAccess {

    @PersistenceContext
    private EntityManager entity;

    @Override
    public void addOrderItem(OrderItem orderItem) {
        entity.persist(orderItem);
        entity.flush();
    }

    @Override
    public void removeOrderItem(OrderItem orderItem) {
        entity.remove(orderItem);
        entity.flush();
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        entity.merge(orderItem);
        entity.flush();
    }

    @Override
    public OrderItem getOrderItem(Long id) {
        TypedQuery<OrderItem> query;
        query = entity.createQuery("select e from tb_order_item e where e.ID =:ID" , OrderItem.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }

    @Override
    public List<OrderItem> getOrderItems() {
        TypedQuery<OrderItem> query;
        query = entity.createQuery("select e from tb_order_item e" , OrderItem.class);
        return query.getResultList();
    }
}
