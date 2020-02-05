package com.accenture.flowershop.be.access.flower;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.accenture.flowershop.be.entity.flower.Flowers;
import java.util.List;

@Transactional
@Repository
public class FlowersAccessImpl implements FlowersAccess {

    @PersistenceContext
    private EntityManager entity;

    @Override
    public void addFlowers(Flowers flowers) {
        entity.persist(flowers);
        entity.flush();
    }

    @Override
    public void removeFlowers(Flowers flowers) {
        entity.remove(flowers);
        entity.flush();
    }

    @Override
    public void updateFlower(Flowers flowers) {
    entity.merge(flowers);
    entity.flush();
    }

    @Override
    public Flowers getFlowers(Long id) {
        TypedQuery<Flowers> query;
        query = entity.createQuery("select e from tb_flowers e where e.ID =:ID", Flowers.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }

    @Override
    public List<Flowers> getAllFlowers() {
        TypedQuery<Flowers> query;
        query = entity.createQuery("select e from tb_flowers e", Flowers.class);
        return (List<Flowers>) query.getSingleResult();
    }
}
