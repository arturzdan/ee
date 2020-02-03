package java.com.accenture.flowershop.be.access.user;

import java.com.accenture.flowershop.be.entity.user.User;
import java.util.List;

public interface UserAccess {

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUser(String login);

    boolean isValid(String login, String password);

    List<User> getUserList();
}
