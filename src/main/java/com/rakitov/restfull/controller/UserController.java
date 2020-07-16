package com.rakitov.restfull.controller;


import com.rakitov.restfull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUser(ModelMap modelMap) {
        modelMap.addAttribute("user", userService.findUserbyEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "user";
    }

}
