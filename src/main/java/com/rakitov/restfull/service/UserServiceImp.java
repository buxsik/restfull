package com.rakitov.restfull.service;

import com.rakitov.restfull.dao.RoleDao;
import com.rakitov.restfull.dao.UserDao;
import com.rakitov.restfull.model.Role;
import com.rakitov.restfull.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp  implements UserService{

    final private UserDao userDao;
    final private RoleDao roleDao;

    @Autowired
    public UserServiceImp(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }


    @Transactional
    @Override
    public User findUserbyId(Long id) {
        return userDao.findUserbyId(id);
    }

    @Transactional
    @Override
    public User findUserbyEmail(String email) {
        return userDao.findUserbyEmail(email);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        /*List<Role> roleList = new ArrayList<>();
        for (String role : roles) {
            roleList.add(roleDao.findRoleByName(role));
        }
        user.setRole(roleList);*/
        userDao.createUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        /*String str = user.getRole().toString().replaceAll("^\\[|\\s|\\]$", "");
        String[] role = str.split(",");
        List<Role> roleList1 = new ArrayList<>();
        for (String roles : role) {
          roleList1.add(roleDao.findRoleByName(roles));
        }
        user.setRole(roleList1);*/
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }
}
