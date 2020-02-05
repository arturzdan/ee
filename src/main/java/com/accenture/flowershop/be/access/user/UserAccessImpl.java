package com.accenture.flowershop.be.access.user;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
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
        TypedQuery<User> query;
        //query = entity.createQuery("select e from tb_user e where e.login =:LOGIN" , User.class);
        //query.setParameter("LOGIN", login);
        return null;//query.getSingleResult();
    }

    @Override
    public boolean isValid(String login, String password) {
        List<User> users = entity.createQuery("SELECT e FROM "+ User.class.getName() +" e WHERE e.login =:LOGIN").setParameter("LOGIN", login).getResultList();

        return true;

        //query = entity.createQuery("from User where login = :LOGIN" , User.class);
        //query.setParameter("LOGIN", login);
        //User user = query.getSingleResult();
        //if(!user.getLogin().equals(login))
        //    return false;
        //if (!user.getPassword().equals(password))
        //    return false;
        //return true;
    }

    @Override
    public List<User> getAllUser() {
        //TypedQuery<User> query;
        List<User> users = entity.createQuery("SELECT e FROM "+ User.class.getName()).getResultList();
        return users;
    }

}
