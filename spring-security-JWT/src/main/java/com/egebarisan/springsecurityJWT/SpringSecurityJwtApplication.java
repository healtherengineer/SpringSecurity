package com.egebarisan.springsecurityJWT;

import com.egebarisan.springsecurityJWT.domain.Role;
import com.egebarisan.springsecurityJWT.domain.User;
import com.egebarisan.springsecurityJWT.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Ege BARISAN", "ege123", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Dilara ELDEMIR", "dilara123", "123", new ArrayList<>()));
            userService.saveUser(new User(null, "Sezaver BARISAN", "seza01", "321", new ArrayList<>()));
            userService.saveUser(new User(null, "Nevzat BARISAN", "canip01", "54321", new ArrayList<>()));

            userService.addRoleToUser("ege123", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("ege123", "ROLE_USER");
            userService.addRoleToUser("dilara123", "ROLE_USER");
            userService.addRoleToUser("seza01", "ROLE_MANAGER");
            userService.addRoleToUser("canip01", "ROLE_SUPER_ADMIN");


        };
    }

}
