package com.rakitov.restfull.service;

import com.rakitov.restfull.dao.RoleDao;
import com.rakitov.restfull.model.Role;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class RoleServiceImp implements RoleService{


    private final RoleDao roleDao;

    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Transactional
    @Override
    public Role findRoleByName(String name) {
        return roleDao.findRoleByName(name);
    }
}
