package com.rakitov.restfull.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Transient
    @JsonIgnore
    @ManyToMany(mappedBy = "role")
    private List<User> users;

    public Role() {}


    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(Long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name= name;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        String role = "";
        if (this.id == 1L) {
            role = "ADMIN";
        }
        if (this.id == 2L) {
            role = "USER";
        }
        return role;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
