package com.example.tracker.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTRepository
        extends JpaRepository<UserT, Long> {

    @Query("SELECT u FROM UserT u WHERE u.email = ?1")
    Optional<UserT> findUserTByEmail(String email);
}
