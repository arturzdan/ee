package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.user.User;

public class UserDto {

    private Long id;
    private String login;
    private String password;

    public UserDto adapter(User user)
    {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
