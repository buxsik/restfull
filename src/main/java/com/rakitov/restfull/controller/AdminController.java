package com.rakitov.restfull.controller;


import com.rakitov.restfull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAdmin(ModelMap modelMap) {
        modelMap.addAttribute("user", userService.findUserbyEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "admin";
    }
}
