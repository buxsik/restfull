package com.rakitov.restfull.service;

import com.rakitov.restfull.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role getRoleByName();
}
