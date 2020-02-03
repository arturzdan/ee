package java.com.accenture.flowershop.be.access.user;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.com.accenture.flowershop.be.entity.user.User;
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
    public void deleteUser(User user) {
        entity.remove(user);
        entity.flush();
    }

    @Override
    public void updateUser(User user) {
        entity.merge(user);
        entity.flush();
    }

    @Override
    public User getUser(String login) {
        TypedQuery<User> query;
        query = entity.createQuery("select e from User e where e.login =:LOGIN" , User.class);
        query.setParameter("LOGIN", login);
        return query.getSingleResult();
    }

    @Override
    public boolean isValid(String login, String password) {
        TypedQuery<User> query;
        query = entity.createQuery("select e from User e where e.login =:LOGIN" , User.class);
        query.setParameter("LOGIN", login);
        User user = query.getSingleResult();
        return true;
    }

    @Override
    public List<User> getUserList() {
        TypedQuery<User> query;
        query = entity.createQuery("select e from User e" , User.class);
        return query.getResultList();
    }

}
