package com.rakitov.restfull.controller;


import com.rakitov.restfull.model.User;
import com.rakitov.restfull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class RESTAdminController {

    private final UserService userService;

    @Autowired
    public RESTAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity <List<User>> read() {
        final List<User> userList = userService.getAllUser();
        return userList != null && userList.isEmpty() ? new ResponseEntity<>(userList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
