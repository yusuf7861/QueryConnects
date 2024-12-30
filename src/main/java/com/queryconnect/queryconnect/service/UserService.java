package com.queryconnect.queryconnect.service;

import com.queryconnect.queryconnect.domain.Users;
import com.queryconnect.queryconnect.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);

    public void registerUser(Users users)
    {
        if(userRepository.findByUsername(users.getUsername()).isPresent())
        {
            logger.error("Attempt to register with existing username: {}", users.getUsername()); throw new IllegalArgumentException("Username already exists.");
        }

        if(userRepository.findByEmail(users.getEmail()).isPresent())
        {
            logger.error("Attempt to register with existing email: {}", users.getEmail()); throw new IllegalArgumentException("Email already exists.");
        }

        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedUser = userRepository.save(users);
        logger.info("New user registered: ID={}, Username={}, Email={}", users.getUserId(),
                users.getUsername(), users.getEmail());
    }
}
