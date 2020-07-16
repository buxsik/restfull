package com.rakitov.restfull.dao;

import com.rakitov.restfull.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    final private EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUser() {
        TypedQuery query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User findUserbyId(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserbyEmail(String email) {

        return entityManager.createQuery("select user from User user where user.email=:thisEmail", User.class)
                .setParameter("thisEmail", email)
                .getSingleResult();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(Long id) {
        User user = findUserbyId(id);
        entityManager.remove(user);
    }
}
