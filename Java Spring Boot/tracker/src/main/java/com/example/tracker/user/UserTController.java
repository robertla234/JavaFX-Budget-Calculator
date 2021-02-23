package com.example.tracker.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserTController {

    private final UserTService userTService;

    @Autowired
    public UserTController(UserTService userTService) {
        this.userTService = userTService;
    }

    @GetMapping
    public List<UserT> getUsers(){
        return userTService.getUsers();
    }
}
