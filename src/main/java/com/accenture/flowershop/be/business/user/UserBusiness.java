package com.accenture.flowershop.be.business.user;

import com.accenture.flowershop.be.entity.user.User;

public interface UserBusiness {
    User login(String login, String password);

    User register(User user);
}
