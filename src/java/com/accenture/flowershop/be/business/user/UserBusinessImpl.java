package com.accenture.flowershop.be.business.user;

import com.accenture.flowershop.be.access.user.UserAccess;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private UserAccess userAccess;

    @Override
    public User login(String login, String password) {
        if (userAccess.isValid(login, password) == true)
            return userAccess.getUser(login);
        return null;
    }

    @Override
    public User register(User user) {
        userAccess.addUser(user);
        return user;
    }
}
