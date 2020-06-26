package com.rakitov.restfull.dao;

import com.rakitov.restfull.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRole();
    Role findRoleByName(String name);
}
