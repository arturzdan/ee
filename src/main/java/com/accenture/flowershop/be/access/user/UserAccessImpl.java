package com.accenture.flowershop.be.access.user;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.accenture.flowershop.be.entity.user.User;
import java.util.List;

@Service
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
        TypedQuery<User> query;
        query = entity.createQuery("select e from tb_user e where e.login =:LOGIN" , User.class);
        query.setParameter("LOGIN", login);
        return query.getSingleResult();
    }

    @Override
    public boolean isValid(String login, String password) {

        TypedQuery<User> from_user = entity.createQuery("from User", User.class);


        TypedQuery<User> query;
        query = entity.createQuery("from User where login = :LOGIN" , User.class);
        query.setParameter("LOGIN", login);
        User user = query.getSingleResult();
        if(!user.getLogin().equals(login))
            return false;
        if (!user.getPassword().equals(password))
            return false;
        return true;
    }

    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query;
        query = entity.createQuery("select e from tb_user e" , User.class);
        return query.getResultList();
    }

}
