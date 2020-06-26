package com.rakitov.restfull.service;

import com.rakitov.restfull.model.User;

import java.util.List;


public interface UserService {

    List<User> getAllUser();
    User findUserbyId(Long id);
    User findUserbyEmail(String email);
    void createUser(User user, String[] roles);
    void updateUser(User user, String[] roles);
    void removeUser(Long id);
}
