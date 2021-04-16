package com.example.tracker_v3.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userrepository){
        return args -> {
            User userInitial = new User(
                    1L,
                    "userInitial",
                    "testEmail@email.com",
                    "user",
                    "Test",
                    "User",
                    "1234567890",
                    passwordEncoder.encode("password"),
                    true
            );
            User userNext = new User(
                    2L,
                    "userNext",
                    "ttee@email.com",
                    "user",
                    "Test2",
                    "User2",
                    "0987654321",
                    passwordEncoder.encode("password"),
                    true
            );
            userrepository.saveAll(
                    List.of(userInitial, userNext)
            );
        };
    }

}