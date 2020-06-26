package com.rakitov.restfull.service;

import com.rakitov.restfull.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {

    final private UserService userService;

    @Autowired
    public UserDetailsServiceImp(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserbyEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
