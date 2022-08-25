package com.egebarisan.springsecurityJWT.repo;

import com.egebarisan.springsecurityJWT.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
