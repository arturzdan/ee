package com.accenture.flowershop.be.access.user;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.accenture.flowershop.be.entity.user.User;
import java.util.List;

@Transactional
@Repository
public class UserAccessImpl implements UserAccess {

    @PersistenceContext
    private EntityManager entity;

    @Override
    public void addUser(User user) {
        entity.persist(user);
        entity.flush(); //заставит данные сохраняться в базе данных немедленно
    }

    @Override
    public void removeUser(User user) {
        entity.remove(user);
        entity.flush();
    }

    @Override
    public void updateUser(User user) {
        entity.merge(user); //Найдёт прикрепленный объект с тем же идентификатором и обновите его.
        entity.flush();
    }

    @Override
    public User getUser(String login) {
        try {
            TypedQuery<User> query = entity.createQuery("SELECT e FROM User e WHERE e.login =:LOGIN" , User.class);
            query.setParameter("LOGIN", login);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        //return (User)entity.createQuery("SELECT e FROM User e WHERE e.login =:LOGIN").setParameter("LOGIN", login).getSingleResult();
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = entity.createQuery("SELECT e FROM User e").getResultList();
        return users;
    }

}
