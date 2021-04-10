package com.example.tracker_v3.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRRepository
        extends JpaRepository<UserR, Long> {
    @Query("SELECT u FROM UserR u WHERE u.userEmail = ?1")
    Optional<UserR> findUserRByEmail(String email);
}
