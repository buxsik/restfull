package com.rakitov.restfull.dao;

import com.rakitov.restfull.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoleDaoImp implements RoleDao{

    final private EntityManager entityManager;

    public RoleDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Role> getAllRole() {
        TypedQuery query = entityManager.createQuery("from Role", Role.class);
        return query.getResultList();
    }

    @Override
    public Role findRoleByName(String name) {
        return entityManager.createQuery("select role from Role role where role.name=:thisName", Role.class)
                .setParameter("thisName", name)
                .getSingleResult();
    }
}
