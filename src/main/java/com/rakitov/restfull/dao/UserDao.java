package com.rakitov.restfull.dao;

import com.rakitov.restfull.model.User;

import java.util.List;


public interface UserDao {
    List<User> getAllUser();
    User findUserbyId(Long id);
    User findUserbyEmail(String email);
    void createUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
}
