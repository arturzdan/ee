package com.accenture.flowershop.be.business.user;

import com.accenture.flowershop.be.entity.user.User;

import java.util.List;

public interface UserBusiness {
    User login(String login, String password);

    User register(User user);

    public List<User> getAllUser();
}
