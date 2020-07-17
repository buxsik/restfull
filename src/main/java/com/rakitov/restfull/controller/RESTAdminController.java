package com.rakitov.restfull.controller;


import com.rakitov.restfull.model.User;
import com.rakitov.restfull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RESTAdminController {

    private final UserService userService;

    @Autowired
    public RESTAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity <List<User>> read() {
        final List<User> userList = userService.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<User> readUser(@PathVariable Long id) {
        User user = userService.findUserbyId(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<List<User>> addUser(@RequestBody User user) {

        userService.createUser(user);
        final List<User> userList = userService.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        userService.updateUser(user);
        User userNew = userService.findUserbyEmail(user.getEmail());
        return new ResponseEntity<>(userNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
    }
}
