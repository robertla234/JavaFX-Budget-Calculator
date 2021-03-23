package com.example.tracker_v2.UserT;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v2/user")
public class UserTController {

    private static final List<UserTemp> USERS = Arrays.asList(
            new UserTemp(1, "Shawn"),
            new UserTemp(2, "Michelle"),
            new UserTemp(3, "Ricky")
    );

    @GetMapping(path = "{userId}")
    public UserTemp getUserT(@PathVariable("userId") Integer userId){
        return USERS.stream()
                .filter(user -> userId.equals(user.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User " + userId + " does not exist."));
    }

}
