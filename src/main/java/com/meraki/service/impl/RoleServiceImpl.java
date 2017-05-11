package com.meraki.service.impl;

import com.meraki.dao.interfaces.RoleDao;
import com.meraki.entity.Role;
import com.meraki.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> getAllUsers() {
        return roleDao.getAllUsers();
    }

    @Override
    public Role getRoleById(int roleId) {
        return roleDao.getRoleById(roleId);
    }

    @Override
    public boolean addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public boolean roleExists(String roleName) {
        return roleDao.roleExists(roleName);
    }

}
