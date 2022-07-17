package com.example.tracker_v3.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v3/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<User> getUser(@RequestParam(value = "userId") Long userid) {
        List<Long> userList = new ArrayList<Long>(){{ add(userid); }};
        return userService.getUser(userList);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_DEFAULT')")
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteUser(@RequestParam(value = "userId") Long id){
        userService.deleteUser(id);
    }

    @PutMapping
    public void updateUserT(
            @RequestParam(value = "userId") Long userid,
            @RequestParam(value = "firstName", required = false) String fname,
            @RequestParam(value = "lastName", required = false) String lname,
            @RequestParam(value = "email", required = false) String email){
        userService.updateUser(userid, fname, lname, email);
    }
}
