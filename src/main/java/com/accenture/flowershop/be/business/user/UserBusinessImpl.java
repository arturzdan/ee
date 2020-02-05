package com.accenture.flowershop.be.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.flowershop.be.access.user.UserAccess;
import com.accenture.flowershop.be.entity.user.User;

import java.util.List;

@Service
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private UserAccess userAccess;

    @Override
    public User login(String login, String password) {
        User user = userAccess.getUser(login);
        if (user == null)
            return null;
        if (!user.getPassword().equals(password))
            return null;
        return user;
    }

    @Override
    public User register(User user) {
        userAccess.addUser(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userAccess.getAllUser();
    }
}
