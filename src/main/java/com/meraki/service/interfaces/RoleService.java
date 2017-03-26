package com.meraki.service.interfaces;

import com.meraki.entity.Role;

import java.util.List;


public interface RoleService {

    List<Role> getAllUsers();

    Role getRoleById(int roleId);

    boolean addRole(Role role);

    boolean roleExists(String roleName);
}
