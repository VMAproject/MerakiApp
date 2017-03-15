package com.meraki.mapper;

import com.meraki.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> getAllUsers();

    User getUserById(int userId);

    User getUserByUsername(String username);

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    boolean userExists(String username);

}
