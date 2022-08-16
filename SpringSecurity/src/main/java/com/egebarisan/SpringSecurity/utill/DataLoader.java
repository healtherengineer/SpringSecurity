package com.egebarisan.SpringSecurity.utill;

import com.egebarisan.SpringSecurity.model.Role;
import com.egebarisan.SpringSecurity.model.User;
import com.egebarisan.SpringSecurity.repository.RoleRepository;
import com.egebarisan.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role roleAdmin = Role.builder().id(1L).roleName("ROLE_ADMIN").build();
        Role roleUser = Role.builder().id(2L).roleName("ROLE_USER").build();
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        List<Role> adminRoleList = new ArrayList<>();
        adminRoleList.add(roleAdmin);

        User admin = User.builder().id(1L).username("Ege").password("12345").roleList(adminRoleList).build();
        userRepository.save(admin);


        List<Role> userRoleList = new ArrayList<>();
        userRoleList.add(roleUser);

        User user1 = User.builder().id(2L).username("Dilara").password("123").roleList(userRoleList).build();
        userRepository.save(user1);

        System.out.println("----ROLES---------");
        roleRepository.findAll().forEach(System.out::println);
        System.out.println("------USERS------");
        userRepository.findAll().forEach(System.out::println);

    }
}
