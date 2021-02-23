package com.example.tracker.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserTService {

    private final UserTRepository userTRepository;

    @Autowired
    public UserTService(UserTRepository userTRepository) {
        this.userTRepository = userTRepository;
    }

    public List<UserT> getUsers(){
        return userTRepository.findAll();
    }

}
