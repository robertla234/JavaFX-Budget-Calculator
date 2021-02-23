package com.example.tracker.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserTConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserTRepository repository) {
        return args -> {
            UserT shawn = new UserT(
                    1L,
                    "shawnevans222",
                    "shawnevans222@gmail.com",
                    "Shawn Evans");
            repository.saveAll(
                    List.of(shawn)
            );
        };
    }
}
