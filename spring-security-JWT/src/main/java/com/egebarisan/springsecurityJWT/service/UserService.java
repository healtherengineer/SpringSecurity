package com.egebarisan.springsecurityJWT.service;

import com.egebarisan.springsecurityJWT.domain.Role;
import com.egebarisan.springsecurityJWT.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
