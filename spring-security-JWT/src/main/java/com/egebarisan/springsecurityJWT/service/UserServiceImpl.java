package com.egebarisan.springsecurityJWT.service;

import com.egebarisan.springsecurityJWT.domain.Role;
import com.egebarisan.springsecurityJWT.domain.User;
import com.egebarisan.springsecurityJWT.repo.RoleRepo;
import com.egebarisan.springsecurityJWT.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to the database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role to the database");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
        log.info("Saving new role{} to the user {} in the database", role.getName(), user.getName());
        //We dont write this line because this class has @Transactional annotaion
        //userRepo.save(user);


    }

    @Override
    public User getUser(String username) {
        log.info("Fetchin User {}" ,username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching User List ");
        return userRepo.findAll();
    }
}
