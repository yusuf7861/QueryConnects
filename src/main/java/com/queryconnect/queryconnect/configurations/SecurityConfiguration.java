package com.queryconnect.queryconnect.configurations;

import com.queryconnect.queryconnect.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorize -> authorize.requestMatchers("/query-connects","/register", "/login").permitAll().anyRequest().authenticated()
                )
        .formLogin(form -> form.loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/", true)
                .permitAll()
        )
                .logout(logout -> logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder, CustomUserDetailService customUserDetailService) throws Exception {
        AuthenticationManagerBuilder builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder);
        return builder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
