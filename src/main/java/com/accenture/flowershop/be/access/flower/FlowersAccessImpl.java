package com.accenture.flowershop.be.access.flower;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.accenture.flowershop.be.entity.flower.Flower;
import java.util.List;

@Transactional
@Repository
public class FlowersAccessImpl implements FlowersAccess {

    @PersistenceContext
    private EntityManager entity;

    @Override
    public void addFlowers(Flower flowers) {
        entity.persist(flowers);
        entity.flush();
    }

    @Override
    public void removeFlowers(Flower flowers) {
        entity.remove(flowers);
        entity.flush();
    }

    @Override
    public void updateFlower(Flower flowers) {
    entity.merge(flowers);
    entity.flush();
    }

    @Override
    public Flower getFlowers(Long id) {
        TypedQuery<Flower> query;
        query = entity.createQuery("SELECT e FROM Flowers e WHERE e.id =:ID", Flower.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }

    @Override
    public List<Flower> getAllFlowers() {
        List<Flower> flowersList =  entity.createQuery("SELECT e FROM Flowers e").getResultList();
    return flowersList;
    }
}
