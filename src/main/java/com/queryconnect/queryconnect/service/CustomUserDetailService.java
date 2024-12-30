package com.queryconnect.queryconnect.service;

import com.queryconnect.queryconnect.domain.Users;
import com.queryconnect.queryconnect.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found with username: "+ username));
        return org.springframework.security.core.userdetails.User.builder()
                .username(users.getUsername())
                .password(users.getPassword())
                .build();
    }
}
