package com.accenture.flowershop.be.business.user;

import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Service;

public interface UserBusiness {
    User login(String login, String password);

    User register(User user);
}
