package com.rakitov.restfull.controller;

import com.rakitov.restfull.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("roleApi")
public class RestRoleController {

    private final RoleService roleService;

    @Autowired
    public RestRoleController(RoleService roleService) {
        this.roleService = roleService;
    }
}
