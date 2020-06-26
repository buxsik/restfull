package com.rakitov.restfull.service;

import com.rakitov.restfull.dao.RoleDao;
import com.rakitov.restfull.dao.UserDao;
import com.rakitov.restfull.model.Role;
import com.rakitov.restfull.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp  implements UserService{

    final private UserDao userDao;
    final private RoleDao roleDao;

    public UserServiceImp(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User findUserbyId(Long id) {
        return userDao.findUserbyId(id);
    }

    @Override
    public User findUserbyEmail(String email) {
        return findUserbyEmail(email);
    }

    @Override
    public void createUser(User user, String[] roles) {
        List<Role> roleList = new ArrayList<>();
        for (String role : roles) {
            roleList.add(roleDao.findRoleByName(role));
        }
        user.setRole(roleList);
        userDao.createUser(user);
    }

    @Override
    public void updateUser(User user, String[] roles) {
        List<Role> roleList = new ArrayList<>();
        for (String role : roles) {
            roleList.add(roleDao.findRoleByName(role));
        }
        user.setRole(roleList);
        userDao.updateUser(user);
    }

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }
}
