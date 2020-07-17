package com.rakitov.restfull.controller;

import com.rakitov.restfull.model.Role;
import com.rakitov.restfull.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roleApi")
public class RestRoleController {

    private final RoleService roleService;

    public RestRoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public ResponseEntity <List<Role>> getAllRole() {
        List<Role> role = roleService.getAllRole();
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
