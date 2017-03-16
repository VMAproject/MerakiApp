package com.meraki.service.impl;

import com.meraki.entity.Role;
import com.meraki.dao.RoleDao;
import com.meraki.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao rolemapper;

    @Override
    public List<Role> getAllUsers() {
        return rolemapper.getAllUsers();
    }

    @Override
    public Role getRoleById(int roleId) {
        return rolemapper.getRoleById(roleId);
    }

    @Override
    public boolean addRole(Role role) {
        return rolemapper.addRole(role);
    }

    @Override
    public boolean roleExists(String roleName) {
        return rolemapper.roleExists(roleName);
    }

}
