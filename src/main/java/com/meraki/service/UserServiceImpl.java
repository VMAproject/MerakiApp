package com.meraki.service;

import com.meraki.entity.User;
import com.meraki.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao usermapper;

    @Override
    public List<User> getAllUsers() {
        return usermapper.getAllUsers();
    }

    @Override
    public User getUserById(int userId) {
        return usermapper.getUserById(userId);
    }

    @Override
    public boolean addUser(User user) {
        return usermapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        usermapper.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        usermapper.deleteUser(userId);
    }

    @Override
    public boolean userExists(String username) {
        return usermapper.userExists(username);
    }

    @Override
    public User getUserByUsername(String username) {
        return usermapper.getUserByUsername(username);
    }

}
