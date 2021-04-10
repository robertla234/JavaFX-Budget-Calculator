package com.example.tracker_v3.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserRConfig {
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
                    "password"
            );
            UserR userNext = new UserR(
                    2L,
                    "ttee@email.com",
                    "user",
                    "Test2",
                    "User2",
                    "0987654321",
                    "password"
            );
            repository.saveAll(
                    List.of(userInitial, userNext)
            );
        };
    }
}
