package com.example.tracker_v3.user;

import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserRConfig {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRRepository repository){
        return args -> {
            UserR userInitial = new UserR(
                    1L,
                    "testEmail@email.com",
                    "user",
                    "Test",
                    "User",
                    "1234567890",
                    passwordEncoder.encode("password")
            );
            UserR userNext = new UserR(
                    2L,
                    "ttee@email.com",
                    "user",
                    "Test2",
                    "User2",
                    "0987654321",
                    passwordEncoder.encode("password")
            );
            repository.saveAll(
                    List.of(userInitial, userNext)
            );
        };
    }
}
