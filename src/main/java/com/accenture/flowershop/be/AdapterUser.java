package com.accenture.flowershop.be;

import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class AdapterUser {
    public static User dtoToUser(UserDto userDto) {
        if (userDto == null)
            return null;
        User user = new User();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static UserDto userToDto(User user) {
        if (user == null)
            return null;
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static List<User> dtoToUser(List<UserDto> listDto) {
        List<User> userList = new ArrayList<>();
        for (UserDto it : listDto)
            userList.add(AdapterUser.dtoToUser(it));
        return userList;
    }

    public static List<UserDto> userToDto(List<User> listUser) {
        List<UserDto> dtoList = new ArrayList<>();
        for (User it : listUser)
            dtoList.add(AdapterUser.userToDto(it));
        return dtoList;
    }
}
