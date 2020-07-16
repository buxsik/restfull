package com.rakitov.restfull.dao;

import com.rakitov.restfull.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao{

    final private EntityManager entityManager;
    @Autowired
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
