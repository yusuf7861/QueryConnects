package com.queryconnect.queryconnect.repository;

import com.queryconnect.queryconnect.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email); // these Optional<Users> method is necessary for validating the email and username that it already exists or not.
    Optional<Users> findByUsername(String username);
}
