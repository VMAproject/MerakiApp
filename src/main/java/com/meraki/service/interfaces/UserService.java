package com.meraki.service.interfaces;

import com.meraki.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int userId);

    User getUserByUsername(String username);

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    boolean userExists(String username);

}
