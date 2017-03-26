
package com.meraki.dao.impl;

import com.meraki.dao.interfaces.UserDao;
import com.meraki.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        String hql = "FROM User";
        return (List<User>) hibernateTemplate.find(hql);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int userId) {
        return hibernateTemplate.get(User.class, userId);
    }

    @Override
    @Transactional
    public boolean addUser(User user) {
        try {
            hibernateTemplate.save(user);
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        hibernateTemplate.delete(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean userExists(String username) {
        String hql = "FROM User";
        List<User> userList = (List<User>) hibernateTemplate.find(hql);
        return userList.size() > 0 ? true : false;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        String hql = "FROM User WHERE username = '" + username + "'";

        List<User> userList = (List<User>) hibernateTemplate.find(hql);

        if (userList.size() > 0) {
            User user = userList.get(0);
            return user;
        } else {
            System.out.println("User Not Found");
            return null;
        }
    }

}
