package java.com.accenture.flowershop.be.access.order;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.com.accenture.flowershop.be.entity.order.Order;

import java.util.List;

@Repository
public class OrderAccessImpl implements OrderAccess {

    @PersistenceContext
    private EntityManager entity;

    @Override
    public void addOrder(Order order) {
        entity.persist(order);
        entity.flush();
    }

    @Override
    public void removeOrder(Order order) {
        entity.remove(order);
        entity.flush();
    }

    @Override
    public void updateOrder(Order order) {
        entity.merge(order);
        entity.flush();
    }

    @Override
    public Order getOrder(Long id) {
        TypedQuery<Order> query;
        query = entity.createQuery("select e from tb_order e where e.ID =:ID" , Order.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }

    @Override
    public List<Order> getOrders() {
        TypedQuery<Order> query;
        query = entity.createQuery("select e from tb_order e" , Order.class);
        return query.getResultList();
    }
}
