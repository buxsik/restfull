package com.rakitov.restfull.controller;


import com.rakitov.restfull.model.User;
import com.rakitov.restfull.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userApi")
public class RestUserController {

    private final UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<User> getUser() {
        return new ResponseEntity<>(userService.findUserbyEmail(SecurityContextHolder.getContext().getAuthentication().getName()), HttpStatus.OK);
    }
}
