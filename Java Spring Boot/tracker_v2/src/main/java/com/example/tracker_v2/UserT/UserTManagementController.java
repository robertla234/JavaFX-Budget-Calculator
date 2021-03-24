package com.example.tracker_v2.UserT;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v2/user")
public class UserTManagementController {

    private static final List<UserTemp> USERS = Arrays.asList(
            new UserTemp(1, "Shawn"),
            new UserTemp(2, "Michelle"),
            new UserTemp(3, "Ricky")
    );

    //can do @PreAuthorize("hasAuthorizy('user:write')")
    //in ASecurityConfig -> @EnableGlobalMethodSecurity(prePostEnabled = true)

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')") //method-level authorization
    public List<UserTemp> getAllUsers(){
        return USERS;
    }

    @PostMapping
    public void registerNewUser(@RequestBody UserTemp user){
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        System.out.print("DELETE ");
        System.out.println(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody UserTemp user){
        System.out.println(String.format("%s %s", userId, user));
    }
}
